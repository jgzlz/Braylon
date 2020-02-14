package com.dev10.braylon.service;

import com.dev10.braylon.data.CustomerDao;
import com.dev10.braylon.models.Customer;
import java.util.ArrayList;
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
    
    public void addCustomer(Customer customer) {
        //Validations Here
        if(customer.getAddress() == null || customer.getCompanyName() == null || customer.getCustomerFirstName() == null || customer.getCustomerLastName() == null || customer.getEmail() == null || customer.getPhone() == null) {
            return;
        }
        cDao.save(customer);
    }

    public void editCustomer(Customer customer) {
        //Validations Here
        if(cDao.findById(customer.getCustomerId()) == null) {
            return;
        }
        if(customer.getAddress() == null || customer.getCompanyName() == null || customer.getCustomerFirstName() == null || customer.getCustomerLastName() == null || customer.getEmail() == null || customer.getPhone() == null) {
            return;
        }
        cDao.save(customer);
    }

    List<Customer> getCustomersByUserId(Integer userId) {
        List<Customer> customers = cDao.findAll();
        List<Customer> toReturn = new ArrayList();
        for(Customer c : customers) {
            if(c.getUser().getUserId() == userId) {
                toReturn.add(c);
            }
        }
        return toReturn;
    }
    
}
