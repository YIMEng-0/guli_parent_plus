package com.luobin.demo.edu;

/**
 * @author Doraemon
 * @date 2023/3/10 20:58
 * @version 1.0
 */
public class Test {
    {
        System.out.println("Instance initialization block");
    }

    public Test() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
    }
}
