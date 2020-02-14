/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.User;
import static org.junit.jupiter.api.Assertions.*;
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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    public UserDaoTest() {
    }

    /**
     * Test of findUserByUsername method, of class UserDao.
     */
    @Test
    public void testFindUserByUsername() {
        User mayzer = userDao.findUserByUsername("Mayzer");
        User jake = userDao.findUserByUsername("Jake");

        assertEquals(mayzer.getEmail(), "mayzer@mayzer.com");
        assertEquals(mayzer.getFirstName(), "Mayzer");
        assertEquals(mayzer.getLastName(), "Muhammed");
//        assertEquals(mayzer.getOrders().size(), 1);

        assertEquals(jake.getEmail(), "jake@jake.com");
        assertEquals(jake.getFirstName(), "Jake");
        assertEquals(jake.getLastName(), "White");
//        assertEquals(jake.getOrders().size(), 2);
    }

    /**
     * Test of findSalesRepCount method, of class UserDao.
     */
    @Test
    public void testFindSalesRepCount() {
        assertEquals(userDao.findSalesRepCount().intValue(), 3);
    }

    /**
     * Test of findAllSalesReps method, of class UserDao.
     */
    @Test
    public void testFindAllSalesReps() {
        assertEquals(3, userDao.findAllSalesReps().size());
    }

    /**
     * Test of findRoleByUsername method, of class UserDao.
     */
    @Test
    public void testFindRoleByUsername() {
        assertEquals("ROLE_ADMIN",userDao.findRoleByUsername("Mayzer"));
    }
}
