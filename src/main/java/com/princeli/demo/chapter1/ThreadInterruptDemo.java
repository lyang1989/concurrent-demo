package com.princeli.demo.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-10 09:51
 **/
public class ThreadInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        demo2();
    }

    public static void demo1() throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
                boolean in = Thread.currentThread().isInterrupted();
                if (in){
                    System.out.println("before:"+in);
                    Thread.interrupted();
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

    public static void demo2() throws InterruptedException {
        Thread thread = new Thread(()->{
            for (;;){
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("before:"+thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("after:"+thread.isInterrupted());

    }
}
