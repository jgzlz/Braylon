package com.dev10.braylon.service;

import com.dev10.braylon.data.CustomerDao;
import com.dev10.braylon.models.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerService {
   
    @Autowired
    CustomerDao cDao;
    
    public List<Customer> findAllCustomers() {
        
        List<Customer> all = cDao.findAll();
        return all;
    }
    
    public List<Customer> findAllCustomersByUsername(String username) {
        List<Customer> all = cDao.findAllCustomersByUserUsername(username);
        
        return all;
    }
    
        public Customer findCustomerById(int customerId) {
        return cDao.findById(customerId).orElse(null);
    }
    
    
}
