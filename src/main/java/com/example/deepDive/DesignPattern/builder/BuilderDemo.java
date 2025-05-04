package com.example.deepDive.DesignPattern.builder;

public class BuilderDemo {

    public static void main(String[] args){
        Waiter waiter = new Waiter();
        pizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        waiter.setPizzaBuilder(hawaiianPizzaBuilder);
        waiter.constructPizza();
        Pizza hawaiiPizza = waiter.getPizza();
        System.out.println(hawaiiPizza.toString());
    }
}
