package com.story.Renting.Entity;

import com.story.Renting.Enum.RentStatus;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize =  1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "rent_duration", nullable = false)
    private int days;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RentStatus status;

    @Column(name = "order_amount", nullable = false)
    private int orderAmount;

    @Column(name = "fine", nullable = false)
    private int fine;

    @Column(name = "total_amount", nullable = false)
    private int totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

    public Order() {
        // Do Nothing
    }

    public Order(long orderId, String productType, String productName, LocalDate orderDate, int days, LocalDate returnDate, RentStatus status, int orderAmount, int fine, int totalAmount, Customer customer) {
        this.orderId = orderId;
        this.productType = productType;
        this.productName = productName;
        this.orderDate = orderDate;
        this.days = days;
        this.returnDate = returnDate;
        this.status = status;
        this.orderAmount = orderAmount;
        this.fine = fine;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public RentStatus getStatus() {
        return status;
    }

    public void setStatus(RentStatus status) {
        this.status = status;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
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
                ", status=" + status +
                ", orderAmount=" + orderAmount +
                ", fine=" + fine +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                '}';
    }
}
