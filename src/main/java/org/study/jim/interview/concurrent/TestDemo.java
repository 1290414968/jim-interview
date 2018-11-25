package org.study.jim.interview.concurrent;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: jim
 * @Date: 2018/11/10 15:59
 * @Description:
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ThreadWait threadWait = new ThreadWait(lock,condition);
        threadWait.start();
        threadWait.join();
        ThreadNotify threadNotify = new ThreadNotify(lock,condition);
        threadNotify.start();

    }
}
