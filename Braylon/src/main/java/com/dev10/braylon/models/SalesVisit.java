package com.dev10.braylon.models;



import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dev10
 */
@Entity
public class SalesVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesVisitId;

    @Column(nullable = false)
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String notes;

//    @ManyToOne
//    @JoinColumn(name = "orderId")
//    private Order order;
    
}

