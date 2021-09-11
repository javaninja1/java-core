package com.hello.defaultmethod;

public interface DefInt {

    default void hello() {
        System.out.println("def meth");
    }
}
