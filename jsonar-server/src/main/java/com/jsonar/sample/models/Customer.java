package com.jsonar.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@ApiModel(value = "Customer", description = "Defines a customer details")
@Entity
@Table(name = "customers")
public class Customer {
    @ApiModelProperty(value = "Customer No", example = "103")
    @Id
    @Column(name = "customerNumber")
    private Integer customerNumber;

    @ApiModelProperty(value = "Customer Name", example = "Atelier graphique")
    @Column(name = "customerName")
    private String customerName;

    @ApiModelProperty(value = "Contact Last Name", example = "Schmitt")
    @Column(name = "contactLastName")
    private String contactLastName;

    @ApiModelProperty(value = "Contact First Name", example = "Carine ")
    @Column(name = "contactFirstName")
    private String contactFirstName;

    @ApiModelProperty(value = "Phone", example = "40.32.2555")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "Address Line 1", example = "4092 Furth Circle")
    @Column(name = "addressLine1")
    private String addressLine1;

    @ApiModelProperty(value = "Address Line 2", example = "Suite 400")
    @Column(name = "addressLine2")
    private String addressLine2;

    @ApiModelProperty(value = "City", example = "Melbourne")
    @Column(name = "city")
    private String city;

    @ApiModelProperty(value = "State", example = "Melbourne")
    @Column(name = "state")
    private String state;

    @ApiModelProperty(value = "Postal Code", example = "3004")
    @Column(name = "postalCode")
    private String postalCode;

    @ApiModelProperty(value = "Country", example = "Australia")
    @Column(name = "country")
    private String country;

//    @Column(name = "salesRepEmployeeNumber")
//    private Integer salesRepEmployeeNumber;

    @ApiModelProperty(value = "Credit Limit", example = "117300.00")
    @Column(name = "creditLimit")
    private BigDecimal creditLimit;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

//    @ApiModelProperty(value = "Employee Number", example = "1370")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
    private Employee employee;

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
