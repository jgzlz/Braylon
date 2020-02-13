package com.dev10.braylon.models;



import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String notes;

//    @ManyToOne
//    @JoinColumn(name = "orderId")
//    private Order order;
    
}

