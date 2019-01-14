package com.princeli.demo.chapter1;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-10 10:09
 **/
public class AtomicDemo {
    private static int count = 0;

    public AtomicDemo() {
        synchronized (this){

        }
    }

    public synchronized static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::inc).start();
        }
        Thread.sleep(4000);
        System.out.println("运行结果"+count);
    }
}
