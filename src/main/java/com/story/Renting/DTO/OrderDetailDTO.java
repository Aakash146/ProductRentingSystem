package com.story.Renting.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.story.Renting.Enum.RentStatus;

import java.time.LocalDate;

public class OrderDetailDTO {

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("cust_id")
    private Long custId;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("rent_duration_in_days")
    private Integer days;

    @JsonProperty("return_date")
    private LocalDate returnDate;

    @JsonProperty("rent_Status")
    private RentStatus rentStatus;

    @JsonProperty("order_amount")
    private Integer orderAmount;

    @JsonProperty("fine")
    private Integer fine;

    @JsonProperty("total_amount")
    private Integer totalAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
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

}
