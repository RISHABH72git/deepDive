package com.example.deepDive.DesignPattern.builder;

public class HawaiianPizzaBuilder implements pizzaBuilder {

    private Pizza pizza;

    public HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        this.pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        this.pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        this.pizza.setTopping("ham with pineapple");
    }

    @Override
    public Pizza getPizza() {
        return this.pizza;
    }
}
