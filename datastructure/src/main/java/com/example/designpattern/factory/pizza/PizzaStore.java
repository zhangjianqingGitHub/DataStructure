package com.example.designpattern.factory.pizza;

import com.example.designpattern.factory.order.OrderPizza;

/**
 * 相当于客户端，订购披萨
 */
public class PizzaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza("greek");
    }
}
