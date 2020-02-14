/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.Bill;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeromepullenjr
 */
@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {

    @Query(value = "SELECT * from bill b where `status` like ?1", nativeQuery = true)
    public List<Bill> findAllByStatus(String status);

    @Query(value = "SELECT * FROM bill b JOIN user u on o.user_id = u.user_id WHERE `status` LIKE ?1 AND u.username = ?2", nativeQuery = true)
    public List<Bill> findAllByStatusAndUserName(String status, String username);

    @Query(value = "SELECT b FROM bill b WHERE `status` LIKE 'completed' AND fulfillment_date > ?1", nativeQuery = true)
    public List<Bill> findAllCompletedDateLimited(LocalDateTime dateCutoff);

}
