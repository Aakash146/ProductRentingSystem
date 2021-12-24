package com.story.Renting.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize =  1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @Column(name = "cust_id")
    private long custId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Transient
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private List<Order> orderDetails = new ArrayList<>();

    public Customer(){
        //Do nothing
    }

    public Customer(final long custId, final String firstName, final String lastName, final String email, final List<Order> orderDetails) {
        this.custId = custId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.orderDetails = orderDetails;
    }

    public long getCustId() { return custId; }

    public void setCustId(long custId) { this.custId = custId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email;}

    public String getFullName() { return firstName + " " + lastName; }

    public List<Order> getOrderDetails() { return orderDetails; }

    public void setOrderDetails(List<Order> orderDetails) { this.orderDetails = orderDetails; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer that = (Customer) o;
        return Objects.equals(custId, that.custId);
    }

    @Override
    public int hashCode() { return Objects.hash(custId); }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
