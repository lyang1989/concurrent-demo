package com.princeli.demo.chapter4;

import java.util.concurrent.CountDownLatch;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-14 10:48
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(()->{
            System.out.println("执行线程1完毕");
            countDownLatch.countDown();
        }).start();


        new Thread(()->{
            System.out.println("执行线程2完毕");
            countDownLatch.countDown();
        }).start();


        new Thread(()->{
            System.out.println("执行线程3完毕");
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.println("执行主线程完毕");
    }
}
