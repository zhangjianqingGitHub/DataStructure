package com.example.designpattern.factory.adsfactory.order;

import com.example.designpattern.factory.adsfactory.pizza.BJCheesePizza;
import com.example.designpattern.factory.adsfactory.pizza.BJPepperPizza;
import com.example.designpattern.factory.adsfactory.pizza.Pizza;

//工厂子类
public class BJFactory implements AbsFactoryInterface {
    @Override
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza("BJ-cheese");
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza("BJ-pepper");
        }

        return pizza;
    }
}
