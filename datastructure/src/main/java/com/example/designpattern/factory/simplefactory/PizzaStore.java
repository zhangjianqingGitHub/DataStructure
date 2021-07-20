package com.example.designpattern.factory.simplefactory;

/**
 * 相当于客户端，订购披萨
 */
public class PizzaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza("greek");
    }
}
