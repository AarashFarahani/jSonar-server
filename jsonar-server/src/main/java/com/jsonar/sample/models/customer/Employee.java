package com.jsonar.sample.models.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;

@ApiModel(value = "Employee", description = "Defines a employee details")
@Entity
@Table(name = "employees")
public class Employee {
    @ApiModelProperty(value = "Employee Number", example = "1002")
    @Id
    @Column(name = "employeeNumber")
    private Integer employeeNumber;

    @ApiModelProperty(value = "Last Name", example = "Murphy")
    @Column(name = "lastName")
    private String lastName;

    @ApiModelProperty(value = "First Name", example = "Diane")
    @Column(name = "firstName")
    private String firstName;

    @ApiModelProperty(value = "Extension", example = "x5800")
    @Column(name = "extension")
    private String extension;

    @ApiModelProperty(value = "Email", example = "dmurphy@classicmodelcars.com")
    @Column(name = "email")
    private String email;

//    @Column(name = "officeCode")
//    private String officeCode;

    @ApiModelProperty(value = "Reports to employee who is in this table (Kinds of self join)", example = "1002")
    @Column(name = "reportsTo")
    private Integer reportsTo;

    @ApiModelProperty(value = "Job Title", example = "President")
    @Column(name = "jobTitle")
    private String jobTitle;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<Customer> customers;

//    @ApiModelProperty(value = "Office Code", example = "1")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode")
    private Office office;

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
