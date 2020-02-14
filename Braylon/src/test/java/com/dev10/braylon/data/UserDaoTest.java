/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findUserByUsername method, of class UserDao.
     */
    @Test
    public void testFindUserByUsername() {
        User mayzer = userDao.findUserByUsername("Mayzer");
        User jake = userDao.findUserByUsername("Jake");
        User marcus = userDao.findUserByUsername("Marcus");

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
     * Test of findRoleByUsername method, of class UserDao.
     */
    @Test
    public void testFindRoleByUsername() {
//        assertEquals(userDao.findRoleByUsername("Mayzer"), this);
//        assertEquals(userDao.findRoleByUsername("Jake"), this);
//        assertEquals(userDao.findRoleByUsername("Marcus"), this);
//          This method is void?         

    }

}
