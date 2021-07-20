package com.example.designpattern.factory.adsfactory.order;


import com.example.designpattern.factory.adsfactory.pizza.LDCheesePizza;
import com.example.designpattern.factory.adsfactory.pizza.LDPepperPizza;
import com.example.designpattern.factory.adsfactory.pizza.Pizza;


public class LDFactory implements AbsFactoryInterface {
    @Override
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza("LD-cheese");
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza("LD-pepper");
        }

        return pizza;
    }
}
