package com.princeli.demo.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-14 09:10
 **/
public class RWLockDemo {

    static Map<String,Object> cacheMap = new HashMap<>();

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock read = readWriteLock.readLock();
    static Lock write = readWriteLock.writeLock();

    public static final Object get(String key){
        read.lock();
        try {
            return cacheMap.get(key);
        }finally {
            read.unlock();
        }
    }

    public static final Object set(String key,Object value){
        write.lock();
        try {
            return cacheMap.put(key, value);
        }finally {
            write.unlock();
        }
    }

}
