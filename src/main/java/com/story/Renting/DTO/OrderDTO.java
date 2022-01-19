package com.story.Renting.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class OrderDTO {

    @JsonProperty("customer_id")
    private Long custId;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("rent_duration_in_days")
    private Integer days;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "custId=" + custId +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", orderDate=" + orderDate +
                ", days=" + days +
                '}';
    }
}
