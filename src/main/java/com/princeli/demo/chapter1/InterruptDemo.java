package com.princeli.demo.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-09 16:42
 **/
public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(()->{
           while (!Thread.currentThread().isInterrupted()){
               i++;
           }
            System.out.println(i);
        },"inerruptDemo");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
