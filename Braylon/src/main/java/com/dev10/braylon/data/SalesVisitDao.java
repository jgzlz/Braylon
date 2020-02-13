/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.SalesVisit;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeromepullenjr
 */
@Repository
public interface SalesVisitDao extends JpaRepository<SalesVisit, Integer> {

    @Query(
            value = "SELECT * FROM sales_visit WHERE visit_date >= ?1",
            nativeQuery = true)
    public List<SalesVisit> findSalesVisitsAfter(LocalDate cutoffDate);

    @Query(value = "SELECT s.* FROM sales_visit s JOIN user u ON s.user_id = u.user_id WHERE u.username = ?1 AND s.visit_date >= ?2",
            nativeQuery = true)
    public List<SalesVisit> findSalesVisitsByUserAfter(String username, LocalDate cutoffDate);

    @Query(value = "SELECT s.* FROM sales_visit s JOIN user u ON s.user_id = u.user_id WHERE u.username = ?1",
            nativeQuery = true)
    public List<SalesVisit> findSalesByUSername(String username);
}
