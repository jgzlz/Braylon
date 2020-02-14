/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author Joe Gonzalez
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerDaoTest {
    
    @Autowired 
    private CustomerDao customerDao;
    
    public CustomerDaoTest() {
    }

    /**
     * Test of findAllCustomersByUserUsername method, of class CustomerDao.
     */
    @Test
    public void testFindAllCustomersByUserUsername() {
       
    }

    /**
     * Test of findAllBySalesRep method, of class CustomerDao.
     */
    @Test
    public void testFindAllBySalesRep() {
    }

    /**
     * Test of findAllCustomersByUserUserIdIsNull method, of class CustomerDao.
     */
    @Test
    public void testFindAllCustomersByUserUserIdIsNull() {
    }

}
