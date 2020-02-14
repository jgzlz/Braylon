/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import java.time.LocalDate;
import java.time.Month;
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
public class SalesVisitDaoTest {

    @Autowired
    private SalesVisitDao salesVisitDao;

    public SalesVisitDaoTest() {
    }


    /**
     * Test of findSalesVisitsAfter method, of class SalesVisitDao.
     */
    @Test
    public void testFindSalesVisitsAfter() {
        assertEquals(salesVisitDao.findSalesVisitsAfter(LocalDate.of(2020, Month.FEBRUARY, 15)).size(), 3);
    }

    /**
     * Test of findSalesVisitsByUserAfter method, of class SalesVisitDao.
     */
    @Test
    public void testFindSalesVisitsByUserAfter() {
        assertEquals(2, salesVisitDao.findSalesVisitsByUserAfter("Jake", LocalDate.of(2020, Month.FEBRUARY, 13)).size());
    }

    /**
     * Test of findSalesByUsername method, of class SalesVisitDao.
     */
    @Test
    public void testFindSalesByUsername() {
        assertEquals(2, salesVisitDao.findSalesByUsername("Mayzer").size());
        assertEquals(2, salesVisitDao.findSalesByUsername("Jake").size());
        assertEquals(1, salesVisitDao.findSalesByUsername("Marcus").size());
    }

}
