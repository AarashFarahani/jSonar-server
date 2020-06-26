package com.jsonar.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@ApiModel(value = "Product", description = "All product info stored here")
@Entity
@Table(name = "products")
public class Product {
    @ApiModelProperty(value = "Product Code", example = "S10_1678")
    @Id
    @Column(name = "productCode")
    private String productCode;

    @ApiModelProperty(value = "Product Name", example = "1969 Harley Davidson Ultimate Chopper")
    @Column(name = "productName")
    private String productName;

//    @Column(name = "productLine")
//    private String productLine;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productLine", referencedColumnName = "productLine")
    private ProductLine productLine;

    @ApiModelProperty(value = "Product Scale", example = "1:10")
    @Column(name = "productScale")
    private String productScale;

    @ApiModelProperty(value = "Product Vendor", example = "Min Lin Diecast")
    @Column(name = "productVendor")
    private String productVendor;

    @ApiModelProperty(value = "Product Description", example = "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.")
    @Column(name = "productDescription")
    private String productDescription;

    @ApiModelProperty(value = "Quantity In Stock", example = "7933")
    @Column(name = "quantityInStock")
    private Integer quantityInStock;

    @ApiModelProperty(value = "Buy Price", example = "48.81")
    @Column(name = "buyPrice")
    private BigDecimal buyPrice;

    @ApiModelProperty(value = "MSRP", example = "95.70")
    @Column(name = "MSRP")
    private BigDecimal MSRP;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }
}
