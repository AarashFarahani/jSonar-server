package com.jsonar.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;

    @Column(name = "orderDate")
    private LocalDate orderDate;

    @Column(name = "requiredDate")
    private LocalDate requiredDate;

    @Column(name = "shippedDate")
    private LocalDate shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;

//    @Column(name = "customerNumber")
//    private Integer customerNumber;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
    private Customer customer;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
