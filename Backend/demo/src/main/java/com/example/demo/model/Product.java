package com.example.demo.model;


public class Product {
    private String productName;
    private double price;

    public Product(String productName, Double price){
        this.productName=productName;
        this.price=price;
    }

    //Getter ve Setter 

    public String getProductName(){
        return productName;
    }
    
    public void setProductName(String productName){
        this.productName=productName;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price=price;
    }
}
