package com.dev10.braylon.controllers;

import com.dev10.braylon.models.User;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController extends MainController{
    
    @GetMapping("/login")
    public String viewLoginPage(Principal principal) {
        
        
        return "login";
    }
    
}
