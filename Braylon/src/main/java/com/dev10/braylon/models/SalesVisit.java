package com.dev10.braylon.models;



import java.time.LocalDate;
import java.util.Objects;
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

    public Integer getSalesVisitId() {
        return salesVisitId;
    }

    public void setSalesVisitId(Integer salesVisitId) {
        this.salesVisitId = salesVisitId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.salesVisitId);
        hash = 71 * hash + Objects.hashCode(this.visitDate);
        hash = 71 * hash + Objects.hashCode(this.customer);
        hash = 71 * hash + Objects.hashCode(this.user);
        hash = 71 * hash + Objects.hashCode(this.location);
        hash = 71 * hash + Objects.hashCode(this.notes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SalesVisit other = (SalesVisit) obj;
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.notes, other.notes)) {
            return false;
        }
        if (!Objects.equals(this.salesVisitId, other.salesVisitId)) {
            return false;
        }
        if (!Objects.equals(this.visitDate, other.visitDate)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
    
    
    
}

