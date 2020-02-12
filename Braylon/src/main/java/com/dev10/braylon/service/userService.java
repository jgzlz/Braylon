package com.dev10.braylon.service;

import com.dev10.braylon.models.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class userService {

    private List<User> users = new ArrayList<>();
    
    public userService() {
        
        
        
    }
    
    public User findUserByUsername(String username) {
        return new User();
    }
    
    
    
}
