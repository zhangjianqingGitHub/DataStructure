package com.example.designpattern.factory.adsfactory.order;

import com.example.designpattern.factory.adsfactory.pizza.Pizza;

public class OrderPizza {

    public OrderPizza(AbsFactoryInterface factory, String orderType) {
        setAbsFactory(factory, orderType);
    }

    private void setAbsFactory(AbsFactoryInterface factory, String orderType) {
        Pizza pizza = factory.createPizza(orderType);

        if (pizza != null) {
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }
}
