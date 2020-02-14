package com.dev10.braylon.service;

import com.dev10.braylon.data.SalesVisitDao;
import com.dev10.braylon.data.UserDao;
import com.dev10.braylon.models.Customer;
import com.dev10.braylon.models.Bill;
import com.dev10.braylon.models.SalesVisit;
import com.dev10.braylon.models.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    UserDao dao;
    
    @Autowired
    SalesVisitDao salesVisitDao;
    
    @Autowired
    customerService cServ;
    
    @Autowired
    billService oServ;
    
    
    public User findUserByUsername(String username) {
        
        User user = dao.findUserByUsername(username);
        
        return user;
    }
    
    public List<User> findAllUsers() {
        
        List<User> myUsers = dao.findAll();
        
        return myUsers;
    }
    
    public List<SalesVisit> findAllSalesVisitsByUsername(String username) {
        List<SalesVisit> salesVisits = salesVisitDao.findSalesByUsername(username);
        
        return salesVisits;
    }
       
    public List<User> findAllSalesReps() {
        List<User> myUsers = dao.findAllSalesReps();
        
        return myUsers;
    }

    public void addUser(User user) {
        //Validations
        if(dao.findUserByUsername(user.getUsername()) != null) {
            return;
        }
        if(user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getUsername() == null) {
            return;
        }
        dao.save(user);
    }

    public void editUser(User user) {
        //Validations
        if(dao.findUserByUsername(user.getUsername()) == null) {
            return;
        }
        if(user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getUsername() == null) {
            return;
        }
        dao.save(user);
    }
}
