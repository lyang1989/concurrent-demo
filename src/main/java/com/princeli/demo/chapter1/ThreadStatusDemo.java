package com.princeli.demo.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-09 15:13
 **/
public class ThreadStatusDemo {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timewaiting").start();


        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class) {
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                };
            }


        },"waiting").start();

        new Thread(new BlockDemo(),"BlockDemo-0").start();
        new Thread(new BlockDemo(),"BlockDemo-1").start();

    }


    static class BlockDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
