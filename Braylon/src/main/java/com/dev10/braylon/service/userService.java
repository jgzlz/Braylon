package com.dev10.braylon.service;

import com.dev10.braylon.data.RoleDao;
import com.dev10.braylon.data.SalesVisitDao;
import com.dev10.braylon.data.UserDao;
import com.dev10.braylon.models.Role;
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
    RoleDao roleDao;
    
    
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
        List<User> myUsers = dao.findAllUsersByRolesRole("ROLE_USER");
        Role admin = roleDao.findRoleByRole("ROLE_ADMIN");
        for (int i = myUsers.size() - 1; i >= 0; i--) {
            if (myUsers.get(i).getRoles().contains(admin)) {
                myUsers.remove(i);
            }
        }
        
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
