package com.princeli.demo.chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-14 09:58
 **/
public class Demo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ThreadWait threadWait = new ThreadWait(lock,condition);
        threadWait.start();
        ThreadNotify threadNotify = new ThreadNotify(lock,condition);
        threadNotify.start();
    }
}
