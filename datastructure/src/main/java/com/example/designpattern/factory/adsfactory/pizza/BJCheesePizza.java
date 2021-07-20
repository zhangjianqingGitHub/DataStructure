package com.example.designpattern.factory.adsfactory.pizza;

public class BJCheesePizza extends Pizza {
    public BJCheesePizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("北京的奶酪pizza 准备原材料");
    }
}
