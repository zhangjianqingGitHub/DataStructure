package com.example.designpattern.factory.factorymethod;

import com.example.designpattern.factory.factorymethod.order.BJOrderPizza;

/**
 * 相当于客户端，订购披萨
 */
public class PizzaStore {
    public static void main(String[] args) {
        BJOrderPizza orderPizza = new BJOrderPizza("cheese");
    }
}
