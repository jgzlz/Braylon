package com.dev10.braylon.service;

import com.dev10.braylon.data.CustomerDao;
import com.dev10.braylon.models.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerService {
   
    @Autowired
    CustomerDao customerDao;
    
    public List<Customer> findAllCustomers() {
        
        List<Customer> all = customerDao.findAll();
        return all;
    }
    
    public List<Customer> findAllCustomersByUsername(String username) {
        List<Customer> all = customerDao.findAllCustomersByUserUsername(username);
        
        return all;
    }
    
    
}
