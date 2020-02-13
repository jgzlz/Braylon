package com.dev10.braylon.service;

import com.dev10.braylon.controllers.MainController;
import com.dev10.braylon.data.UserDao;
import com.dev10.braylon.models.MyUserDetails;
import com.dev10.braylon.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserDao uDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = uDao.findUserByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Not Found: " + username);
        }
        
        
        MyUserDetails userDetails = new MyUserDetails(user);
        
        MainController.currentUser = user;
        
        //create my user details object from the User entity
        //The user entity is returned from JPA Repo and looked up by ID/UserName
        return userDetails;
    }
    
}
