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
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private LocalDateTime fulfillmentDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double price;

    @ManyToMany
    @JoinTable(name = "orderProduct",
    joinColumns = {@JoinColumn(name = "orderId")},
    inverseJoinColumns = {@JoinColumn(name = "productId")})
    private List<Product> products;

    
    
}
