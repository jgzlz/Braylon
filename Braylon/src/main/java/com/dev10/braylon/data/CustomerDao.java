/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author G10-DEV10W3
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    public List<Customer> findAllCustomersByUserUsername(String username);
    
    @Query(value = "SELECT * from Customer c where user_id like ?1", nativeQuery = true)
    public List<Customer> findAllBySalesRep(String salerep);
    
//    @Query(value = "SELECT * from Customer c where userId is null")
//    public List<Customer> findAllBySalesRepWithNulls();
    
    public List<Customer> findAllCustomersByUserUserIdIsNull();
    
}
