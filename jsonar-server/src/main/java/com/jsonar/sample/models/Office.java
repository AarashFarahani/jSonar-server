package com.jsonar.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;

@ApiModel(value = "Office", description = "Defines a office details")
@Entity
@Table(name = "offices")
public class Office {
    @ApiModelProperty(value = "Office Code", example = "1")
    @Id
    @Column(name = "officeCode")
    private String officeCode;

    @ApiModelProperty(value = "City", example = "San Francisco")
    @Column(name = "city")
    private String city;

    @ApiModelProperty(value = "Phone", example = "+1 650 219 4782")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "Address Line 1", example = "100 Market Street")
    @Column(name = "addressLine1")
    private String addressLine1;

    @ApiModelProperty(value = "Address Line 2", example = "Suite 300")
    @Column(name = "addressLine2")
    private String addressLine2;

    @ApiModelProperty(value = "State", example = "CA")
    @Column(name = "state")
    private String state;

    @ApiModelProperty(value = "Country", example = "USA")
    @Column(name = "country")
    private String country;

    @ApiModelProperty(value = "Postal Code", example = "94080")
    @Column(name = "postalCode")
    private String postalCode;

    @ApiModelProperty(value = "Territory", example = "NA")
    @Column(name = "territory")
    private String territory;

    @JsonIgnore
    @OneToMany(mappedBy = "office")
    private Set<Employee> employees;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
