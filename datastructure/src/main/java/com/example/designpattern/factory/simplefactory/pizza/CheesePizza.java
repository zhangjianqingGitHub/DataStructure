package com.example.designpattern.factory.simplefactory.pizza;

public class CheesePizza extends Pizza{
    public CheesePizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("奶酪披萨准备原材料");
    }
}
