package com.example.designpattern.factory.factorymethod.order;

import com.example.designpattern.factory.factorymethod.pizza.LDCheesePizza;
import com.example.designpattern.factory.factorymethod.pizza.LDPepperPizza;
import com.example.designpattern.factory.factorymethod.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {
    public LDOrderPizza(String mOrderType) {
        super(mOrderType);
    }

    @Override
    Pizza createPizza(String mOrderType) {
        Pizza pizza = null;
        if (mOrderType.equals("cheese")) {
            pizza = new LDCheesePizza("cheese");
        } else if (mOrderType.equals("pepper")) {
            pizza = new LDPepperPizza("pepper");
        }

        return pizza;
    }
}
