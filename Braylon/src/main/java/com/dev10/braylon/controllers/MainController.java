package com.dev10.braylon.controllers;


import com.dev10.braylon.models.Order;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Role> userRoles = currentUser.getRoles();
        boolean isAdmin = false;
        for(Role r : userRoles) {
            if(r.getRole() == "ROLE_ADMIN") {
                isAdmin = true;
            }
        }
        if(isAdmin) {
            return "homeAdmin";
        }
        else {
            List<SalesVisit> visits = uServ.findAllSalesVisitsByUsername(currentUser.getUsername());
            model.addAttribute("orders", currentUser.getOrders());
            model.addAttribute("salesVisits", visits);
            
            return "homeSalesRep";
        }
    }
    
    //Adding SalesVisit
    @GetMapping("/addSalesVisit")
    public String viewAddSalesVisit(Model model, SalesVisit visit) {
        
        return "addSalesVisit";
    }
    
    @PostMapping("/addSalesVisit")
    public String processAddSalesVisit(Model model, SalesVisit visit) {
        
        return "redirect:/home";
    }
    
    //Adding Order
    @GetMapping("/addOrder")
    public String viewAddOrder(Model model, Order order) {
        
        return "addOrder";
    }
    
    @PostMapping("/addOrder")
    public String processAddOrder(Principal principal, Model model, Order order) {
        
        return "redirect:/home";
    }
}
