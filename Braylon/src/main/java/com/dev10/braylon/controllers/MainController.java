package com.dev10.braylon.controllers;


import com.dev10.braylon.models.Customer;
import com.dev10.braylon.models.Role;
import com.dev10.braylon.models.SalesVisit;
import com.dev10.braylon.models.User;
import com.dev10.braylon.service.customerService;
import com.dev10.braylon.service.orderService;
import com.dev10.braylon.service.productService;
import com.dev10.braylon.service.salesVisitService;
import com.dev10.braylon.service.userService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/addCustomer")
    public String loadAddingCustomer(Model model) {
        if(userIsAdmin()) {
            model.addAttribute("salesReps", uServ.findAllSalesReps());
        }
        model.addAttribute("customer", null);
        return "addCustomer";
    }
    
    @PostMapping("/addCustomer")
    public String addNewCustomer() {
        
    }
    
    @GetMapping("/editCustomer/{customerId}")
    public String loadEditCustomer(Model model, @PathVariable int customerId) {
        Customer customer = 
        if(userIsAdmin()) {
            model.addAttribute("salesReps", uServ.findAllSalesReps());
        }
        model.addAttribute("customer", customer);
        return "addCustomer";
    }
    
    @PostMapping("/editCustomer")
    
    
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
