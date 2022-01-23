package com.story.Renting.Entity;

import com.story.Renting.Enum.RentStatus;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Product_order")
public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize =  1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "rent_duration", nullable = false)
    private Integer days;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RentStatus rentStatus;

    @Column(name = "order_amount", nullable = false)
    private Integer orderAmount;

    @Column(name = "fine", nullable = false)
    private Integer fine;

    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

    public Order() {
        // Do Nothing
    }

    public Order(Long orderId, String productType, String productName, LocalDate orderDate, Integer days, LocalDate returnDate, RentStatus rentStatus, Integer orderAmount, Integer fine, Integer totalAmount, Customer customer) {
        this.orderId = orderId;
        this.productType = productType;
        this.productName = productName;
        this.orderDate = orderDate;
        this.days = days;
        this.returnDate = returnDate;
        this.rentStatus = rentStatus;
        this.orderAmount = orderAmount;
        this.fine = fine;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() { return Objects.hash(orderId); }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", orderDate=" + orderDate +
                ", days=" + days +
                ", returnDate=" + returnDate +
                ", status=" + rentStatus +
                ", orderAmount=" + orderAmount +
                ", fine=" + fine +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                '}';
    }


}
