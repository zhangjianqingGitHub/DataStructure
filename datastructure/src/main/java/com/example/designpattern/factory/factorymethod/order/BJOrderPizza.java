package com.example.designpattern.factory.factorymethod.order;

import com.example.designpattern.factory.factorymethod.pizza.BJCheesePizza;
import com.example.designpattern.factory.factorymethod.pizza.BJPepperPizza;
import com.example.designpattern.factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
    public BJOrderPizza(String mOrderType) {
        super(mOrderType);
    }

    @Override
    Pizza createPizza(String mOrderType) {
        Pizza pizza = null;
        if (mOrderType.equals("cheese")) {
            pizza = new BJCheesePizza("BJ-cheese");
        } else if (mOrderType.equals("pepper")) {
            pizza = new BJPepperPizza("BJ-pepper");
        }

        return pizza;
    }
}
