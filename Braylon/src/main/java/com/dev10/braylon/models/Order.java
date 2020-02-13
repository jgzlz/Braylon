/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev10.braylon.models;


import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Dev10
 */
@Entity
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private LocalDateTime fulfillmentDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double price;

    @ManyToMany
    @JoinTable(name = "order_product",
    joinColumns = {@JoinColumn(name = "order_id")},
    inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products;

    
    
}
