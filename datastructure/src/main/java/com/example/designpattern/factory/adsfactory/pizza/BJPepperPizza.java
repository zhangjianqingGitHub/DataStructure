package com.example.designpattern.factory.adsfactory.pizza;

public class BJPepperPizza extends Pizza {
    public BJPepperPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("北京的胡椒pizza 准备原材料");
    }
}
