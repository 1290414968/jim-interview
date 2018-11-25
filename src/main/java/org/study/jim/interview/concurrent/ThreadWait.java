package org.study.jim.interview.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: jim
 * @Date: 2018/11/10 15:54
 * @Description:
 */
public class ThreadWait  extends Thread {
    private Lock lock;
    private Condition condition;
    public ThreadWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();
        System.out.println("开始执行 thread await");
        try {
            condition.await();
            System.out.println("执行结束 thread await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
