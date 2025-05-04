package com.example.deepDive.DesignPattern.builder;

public interface pizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
    Pizza getPizza();
}
