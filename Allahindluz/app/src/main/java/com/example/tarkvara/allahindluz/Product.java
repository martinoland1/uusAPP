package com.example.tarkvara.allahindluz;

public class Product {

    private String name;
    private double oldPrice;
    private double newPrice;
    private String shop;

    public Product(String name, double oldPrice, double newPrice, String shop){
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.shop = shop;
    }

    public String getName(){
        return name;
    }
    public double getOldPrice(){
        return oldPrice;
    }
    public double getNewPrice(){
        return newPrice;
    }
    public String getShop(){
        return shop;
    }
    public String getOldPriceString(){
        return String.valueOf(oldPrice) + "€";
    }
    public String getNewPriceString(){
        return String.valueOf(newPrice) + "€";
    }
}
