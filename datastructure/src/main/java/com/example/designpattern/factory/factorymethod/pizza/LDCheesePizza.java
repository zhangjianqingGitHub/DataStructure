package com.example.designpattern.factory.factorymethod.pizza;

public class LDCheesePizza extends Pizza {
    public LDCheesePizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("伦敦的奶酪pizza 准备原材料");
    }
}
