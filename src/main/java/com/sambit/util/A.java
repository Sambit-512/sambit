package com.sambit.util;

public class A {

    int x =10;
    public static void main(String[] args) {
        B b1 = new B();
        int i = b1.otpGen();
        System.out.println(i);
             A a1 = new A();
        int test = a1.test();
        System.out.println(test);
    }
    public int test() {
        return 100;
    }

}
