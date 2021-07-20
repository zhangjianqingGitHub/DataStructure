package com.example.designpattern.factory.adsfactory.order;

import com.example.designpattern.factory.adsfactory.pizza.Pizza;

/**
 * 抽象工厂模式的抽象层（接口）
 */
public interface AbsFactoryInterface {
    Pizza createPizza(String orderType);
}
