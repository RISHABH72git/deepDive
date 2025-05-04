package com.example.deepDive.DesignPattern.builder;

public class Pizza {

    private String sauce = "";
    private String topping = "";
    private String dough = "";

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String toString() {
        return this.sauce + this.topping + this.dough;
    }

    public Pizza() {

    }
}
