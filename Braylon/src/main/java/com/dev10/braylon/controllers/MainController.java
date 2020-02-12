package com.dev10.braylon.controllers;


import com.dev10.braylon.models.Order;
import com.dev10.braylon.models.Customer;
import com.dev10.braylon.models.Product;
import com.dev10.braylon.models.Role;
import com.dev10.braylon.models.SalesVisit;
import com.dev10.braylon.models.User;
import com.dev10.braylon.service.customerService;
import com.dev10.braylon.service.orderService;
import com.dev10.braylon.service.productService;
import com.dev10.braylon.service.salesVisitService;
import com.dev10.braylon.service.userService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public abstract class MainController {
    
    protected User currentUser;
    
    @Autowired
    private customerService cServ;
    
    @Autowired
    private orderService oServ;
    
    @Autowired
    private productService pServ;
    
    @Autowired
    private salesVisitService svServ;
    
    @Autowired
    private userService uServ;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/home")
    public String loadHomePage(Model model) {
        if(userIsAdmin()) {
            return "homeAdmin";
        }
        else {
            List<SalesVisit> visits = uServ.findAllSalesVisitsByUsername(currentUser.getUsername());
            model.addAttribute("orders", currentUser.getOrders());
            model.addAttribute("salesVisits", visits);
            return "homeSalesRep";
        }
    }
    
    @GetMapping("/customers")
    public String loadCustomerView(Model model) {
        List<Customer> custList;
        if(userIsAdmin()) {
            custList = cServ.findAllCustomers();
        }
        else {
            custList = cServ.findAllCustomersByUsername(currentUser.getUsername());
        }
        model.addAttribute("customers", custList);
        return "customers";
    }
    
    //Adding Customer
    @GetMapping("/addCustomer")
    public String loadAddingCustomer(Model model) {
        if(userIsAdmin()) {
            model.addAttribute("salesReps", uServ.findAllSalesReps());
        }
        model.addAttribute("customer", null);
        return "customerDetails";
    }
    
    @PostMapping("/addCustomer")
    public String addNewCustomer(Customer customer) {
        cServ.addCustomer(customer);
        return "redirect:/home";
    }
    
    //Editing Customer
    @GetMapping("/editCustomer/{customerId}")
    public String loadEditCustomer(Model model, @PathVariable int customerId) {
        Customer customer = cServ.findCustomerById(customerId);
        if(userIsAdmin()) {
            model.addAttribute("salesReps", uServ.findAllSalesReps());
        }
        model.addAttribute("customer", customer);
        return "customerDetails";
    }
    
    @PostMapping("/editCustomer/{customerId}")
    public String editCustomer(@PathVariable int customerId, Customer customer) {
        cServ.editCustomer(customer);
        return "redirect:/home";
    }
    
    //Adding SalesRep
    @GetMapping("/addSalesRep")
    public String loadAddingSalesRep() {
        return "salesRepDetails";
    }
    
    @PostMapping("/addSalesRep")
    public String addNewSalesRep(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        uServ.addUser(user);
        return "redirect:/home";
    }
    
    //Editing SalesRep
    @GetMapping("/editSalesRep/{username}")
    public String loadEditSalesRep(Model model, @PathVariable String username) {
        User user = uServ.findUserByUsername(username);
        model.addAttribute("salesRep", user);
        return "salesRepDetails";
    }
    
    @PostMapping("/editSalesRep/{username}")
    public String editSalesRep(@PathVariable String username, User user) {
        uServ.editUser(user);
        return "redirect:/home";
    }
    
    //Adding SalesVisit
    @GetMapping("/addSalesVisit")
    public String viewAddSalesVisit(Model model) {
        List<Customer> customers = cServ.findAllCustomersByUsername(currentUser.getUsername());
        model.addAttribute("customers", customers);
        return "addSalesVisit";
    }
    
    @PostMapping("/addSalesVisit")
    public String processAddSalesVisit(SalesVisit visit) {
        svServ.addSalesVisit(visit);
        return "redirect:/home";
    }
    
    //Adding Order
    @GetMapping("/addOrder")
    public String viewAddOrder(Model model, Order order) {
        List<Customer> customers = cServ.findAllCustomersByUsername(currentUser.getUsername());
        model.addAttribute("customers", customers);
        List<Product> products = pServ.findAllProducts();
        model.addAttribute("products", products);
        return "addOrder";
    }
    
    @PostMapping("/addOrder")
    public String processAddOrder(Principal principal, Order order) {
        oServ.addOrder(order);
        return "redirect:/home";
    }
    
    
    private boolean userIsAdmin() {
        List<Role> userRoles = currentUser.getRoles();
        boolean isAdmin = false;
        for(Role r : userRoles) {
            if(r.getRole() == "ROLE_ADMIN") {
                isAdmin = true;
            }
        }
        return isAdmin;
    }
    
}
