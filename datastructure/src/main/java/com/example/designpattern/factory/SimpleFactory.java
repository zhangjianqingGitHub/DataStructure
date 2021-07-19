package com.example.designpattern.factory;

import com.example.designpattern.factory.pizza.CheesePizza;
import com.example.designpattern.factory.pizza.GreekPizza;
import com.example.designpattern.factory.pizza.PepperPizza;
import com.example.designpattern.factory.pizza.Pizza;

//简单工厂类
public class SimpleFactory {

    public static Pizza createPizza(String orderType) {

        Pizza pizza = null;

        switch (orderType) {
            case "greek":
                pizza = new GreekPizza(orderType);
                break;
            case "cheese":
                pizza = new CheesePizza(orderType);
                break;
            case "pepper":
                pizza = new PepperPizza(orderType);
                break;
            default:
                System.out.println("输入错误");
                break;
        }

        return pizza;
    }

}
