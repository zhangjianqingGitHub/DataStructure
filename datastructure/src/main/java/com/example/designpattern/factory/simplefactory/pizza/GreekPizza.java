package com.example.designpattern.factory.simplefactory.pizza;

public class GreekPizza extends Pizza {
    public GreekPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("希腊披萨准备原材料");
    }
}
