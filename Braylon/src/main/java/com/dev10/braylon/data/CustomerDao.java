/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jeromepullenjr
 */
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    public List<Customer> findAllCustomersByUserUsername(String username);
    
}
