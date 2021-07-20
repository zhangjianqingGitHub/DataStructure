package com.example.designpattern.factory.adsfactory;


import com.example.designpattern.factory.adsfactory.order.BJFactory;
import com.example.designpattern.factory.adsfactory.order.OrderPizza;

/**
 * 相当于客户端，订购披萨
 */
public class PizzaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza=new OrderPizza(new BJFactory(),"cheese");
    }
}
