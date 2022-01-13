package tsdv.basicspringbootweb.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "product_detail_id")
    private Long id;

    @NotNull
    private String brand;

    @NotNull
    private String color;

    private double price;

    private Long size_40;

    private Long size_41;

    private Long size_42;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getSize_40() {
        return size_40;
    }

    public void setSize_40(Long size_40) {
        this.size_40 = size_40;
    }

    public Long getSize_41() {
        return size_41;
    }

    public void setSize_41(Long size_41) {
        this.size_41 = size_41;
    }

    public Long getSize_42() {
        return size_42;
    }

    public void setSize_42(Long size_42) {
        this.size_42 = size_42;
    }
}
