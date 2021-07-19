package com.example.designpattern.factory.order;

import com.example.designpattern.factory.SimpleFactory;
import com.example.designpattern.factory.pizza.Pizza;

/**
 * 订购pizza
 */
public class OrderPizza {

    public OrderPizza(String mOrderType) {
        Pizza pizza = SimpleFactory.createPizza(mOrderType);

        if (pizza != null) {
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }

    }


}
