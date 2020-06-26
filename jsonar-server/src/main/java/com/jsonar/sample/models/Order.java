package com.jsonar.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@ApiModel(value = "Order", description = "All order stored here")
@Entity
@Table(name = "orders")
public class Order {
    @ApiModelProperty(value = "Order Number", example = "10100")
    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;

    @ApiModelProperty(value = "Order Date", example = "2003-01-06")
    @Column(name = "orderDate")
    private LocalDate orderDate;

    @ApiModelProperty(value = "Required Date", example = "2003-01-13")
    @Column(name = "requiredDate")
    private LocalDate requiredDate;

    @ApiModelProperty(value = "Shipped Date", example = "2003-01-10")
    @Column(name = "shippedDate")
    private LocalDate shippedDate;

    @ApiModelProperty(value = "Status", example = "Shipped")
    @Column(name = "status")
    private String status;

    @ApiModelProperty(value = "Comment", example = "Check on availability.")
    @Column(name = "comments")
    private String comments;

//    @Column(name = "customerNumber")
//    private Integer customerNumber;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
    private Customer customer;

    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetail;

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

    public Set<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Set<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
