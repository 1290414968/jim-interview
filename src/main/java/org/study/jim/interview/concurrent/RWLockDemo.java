package org.study.jim.interview.concurrent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: jim
 * @Date: 2018/10/28 14:12
 * @Description:
 */
public class RWLockDemo {
    static Map<String,Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    public static Object getKey(String key){
        readLock.lock();
        Object object = cacheMap.get(key);
        readLock.unlock();
        return object;
    }
    public static Object put(String key,Object value){
        writeLock.lock();
        Object object = cacheMap.put(key,value);
        writeLock.unlock();
        return object;
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Thread t = new Thread();
        Thread.interrupted();
    }
}
