package Composite;

import java.io.Serializable;

public class BaseProduct implements MenuItem, Serializable {

    private int id;
    private String name;
    private double price;

    public BaseProduct(String name, double price) {
        this.name = name;
        this.price = price;
        this.id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public double computePrice() {
        return price;
    }

    @Override
    public String getProduct() {
        return this.name;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }

}