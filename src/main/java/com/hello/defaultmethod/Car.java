package com.hello.defaultmethod;

public class Car implements DefInt {

    public Car() {
        hello();
    }

    public void hello() {
        DefInt.super.hello();
        System.out.println("class meth");
    }
    public static void main(String args[]) {
        new Car();
    }
}
