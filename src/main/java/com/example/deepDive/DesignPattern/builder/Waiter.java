package com.example.deepDive.DesignPattern.builder;

public class Waiter {
    private pizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(pizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        this.pizzaBuilder.buildDough();
        this.pizzaBuilder.buildSauce();
        this.pizzaBuilder.buildTopping();
    }
}
