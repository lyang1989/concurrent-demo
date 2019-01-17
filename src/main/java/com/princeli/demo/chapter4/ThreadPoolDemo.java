package com.princeli.demo.chapter4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-16 10:51
 **/
public class ThreadPoolDemo implements Runnable{
    //static ExecutorService executorService = Executors.newFixedThreadPool(3);

    //static ExecutorService executorService = Executors.newCachedThreadPool();

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadPoolExecutor tpe =  (ThreadPoolExecutor)executorService;
        tpe.setCorePoolSize(2);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThreadPoolDemo());
        }
        executorService.shutdown();
    }
}
