package com.dev10.braylon.service;

import com.dev10.braylon.data.CustomerDao;
import com.dev10.braylon.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerService {
    @Autowired
    CustomerDao cDao;

    public customerService() {
    }
    
    public Customer findCustomerById(int customerId) {
        return cDao
    }
}
