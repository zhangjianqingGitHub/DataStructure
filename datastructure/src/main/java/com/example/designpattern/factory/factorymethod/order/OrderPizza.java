package com.example.designpattern.factory.factorymethod.order;


import com.example.designpattern.factory.factorymethod.pizza.Pizza;

/**
 * 订购pizza
 */
public abstract class OrderPizza {

    //方法工厂
    abstract Pizza createPizza(String mOrderType);

    public OrderPizza(String mOrderType) {
        Pizza pizza = createPizza(mOrderType);

        if (pizza != null) {
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }

    }


}
