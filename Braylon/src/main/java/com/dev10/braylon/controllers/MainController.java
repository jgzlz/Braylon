package com.dev10.braylon.controllers;


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
            List<SalesVisit> visits = uServ.findSalesByUser(currentUser.getUsername());
            model.addAttribute("orders", currentUser.getOrders());
        }
    }
    
}
