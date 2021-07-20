package com.example.designpattern.factory.simplefactory;


import com.example.designpattern.factory.simplefactory.pizza.Pizza;

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
