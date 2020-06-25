package com.jsonar.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;

//    @Column(name = "productCode")
//    private String productCode;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productCode", referencedColumnName = "productCode")
    private Product product;

    @Column(name = "quantityOrdered")
    private Integer quantityOrdered;

    @Column(name = "priceEach")
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber")
    private Integer orderLineNumber;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}
