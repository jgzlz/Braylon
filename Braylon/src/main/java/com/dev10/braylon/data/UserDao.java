/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.data;

import com.dev10.braylon.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeromepullenjr
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
//    @Query(value="Select u from User u where username like ?1",nativeQuery=true)

    public User findUserByUsername(String username);

    @Query(value = "Select u from User u where username like ?1", nativeQuery = true)
    public User findUserUsername(String username);

    @Query(value = "SELECT COUNT(u.*) FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id WHERE r.role LIKE 'salesrep'",
            nativeQuery = true)
    public Integer findSalesRepCount();

    @Query(value = "SELECT u.* FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id WHERE r.role LIKE 'salesrep'",
            nativeQuery = true)
    public List<User> findAllSalesReps();

    @Query(value = "SELECT r.role FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id WHERE u.username LIKE ?1",
            nativeQuery = true)
    public String findRoleByUsername(String username);

}
