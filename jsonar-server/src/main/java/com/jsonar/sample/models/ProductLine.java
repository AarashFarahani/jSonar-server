package com.jsonar.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    @Column(name = "productLine")
    private String productLine;

    @Column(name = "textDescription")
    private String textDescription;

    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @JsonIgnore
    @OneToMany(mappedBy = "productLine")
    private Set<Product> products;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
