package com.princeli.demo.chapter2;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-10 13:22
 **/
public class ThreadDemo {
    private static volatile ThreadDemo instance = null;

    public static ThreadDemo getInstance(){
        if (instance == null){
            instance = new ThreadDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadDemo.getInstance();
    }

}
