/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

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
public class OrderDaoTest {
    
    @Autowired
    private OrderDao orderDao;
    
    public OrderDaoTest() {
    }
    
   
}
