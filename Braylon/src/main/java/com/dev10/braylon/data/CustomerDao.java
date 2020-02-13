/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.Customer;
import com.dev10.braylon.models.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author G10-DEV10W3
 */
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    
    @Query(value = "SELECT * from customer c where user_id like ?1", nativeQuery = true)
    public List<Customer> findAllByUser(String user);
    
    @Query(value = "SELECT * from customer c where user_id is null", nativeQuery = true)
    public List<Customer> findAllByUserWithNulls(String user);
    
}
