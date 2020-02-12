/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import java.util.List;

/**
 *
 * @author G10-DEV10W3
 */
public interface CustomerDao extends JpaRepository<Order, Integer> {
    
    @Query(value = "SELECT * from Customer c where SalesRepId like ?1", nativeQuery = true)
    public List<Order> findAllBySalesRep(String salerep);
    
    @Query(value = "SELECT * from Customer c where SalesRepId is null")
    public List<Order> findAllBySalesRepWithNulls(String status, String username);
    
}
