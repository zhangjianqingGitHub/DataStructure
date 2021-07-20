package com.example.designpattern.factory.adsfactory.pizza;

//将Pizza类做成抽象的
public abstract class Pizza {
    protected String name;

    public Pizza(String name) {
        this.name = name;
    }

    //准备原材料，种类不同，原材料不同
    public abstract void prepare();

    //烘烤
    public void bake() {
        System.out.println(name + ":baking");
    }

    //切
    public void cut() {
        System.out.println(name + ":catting");

    }

    //打包
    public void box() {
        System.out.println(name + ":boxing");

    }
}
