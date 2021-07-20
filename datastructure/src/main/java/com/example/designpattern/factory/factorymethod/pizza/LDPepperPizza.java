package com.example.designpattern.factory.factorymethod.pizza;

public class LDPepperPizza extends Pizza {
    public LDPepperPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("伦敦的胡椒pizza 准备原材料");
    }
}
