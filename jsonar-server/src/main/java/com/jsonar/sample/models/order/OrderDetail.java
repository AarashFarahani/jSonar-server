package com.jsonar.sample.models.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsonar.sample.models.product.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@ApiModel(value = "Order Details", description = "All order details stored here")
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @ApiModelProperty(value = "Order Number", example = "10100")
    @Column(name = "orderNumber")
    private Integer orderNumber;

    @Id
    @Column(name = "productCode")
    private String productCode;
//    @JsonIgnore
    @ApiModelProperty(value = "Product Code", example = "S18_1749")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productCode", referencedColumnName = "productCode")
    private Product product;

    @ApiModelProperty(value = "Quantity Ordered", example = "30")
    @Column(name = "quantityOrdered")
    private Integer quantityOrdered;

    @ApiModelProperty(value = "Price Each", example = "136.00")
    @Column(name = "priceEach")
    private BigDecimal priceEach;

    @ApiModelProperty(value = "Order Line Number", example = "3")
    @Column(name = "orderLineNumber")
    private Integer orderLineNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber",//TODO
            insertable = false, updatable = false)
    private Order order;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
