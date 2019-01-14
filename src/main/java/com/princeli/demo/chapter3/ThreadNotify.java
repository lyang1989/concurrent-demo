package com.princeli.demo.chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-14 09:53
 **/
public class ThreadNotify extends Thread{

    private Lock lock;

    private Condition condition;

    public ThreadNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("开始执行 thread notify");
            condition.signal();
            System.out.println("执行结束 thread notify");
        }finally {
            lock.unlock();
        }
    }
}
