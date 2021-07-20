package com.example.designpattern.factory.simplefactory.pizza;

public class PepperPizza extends Pizza {
    public PepperPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("胡椒披萨准备原材料");
    }
}
