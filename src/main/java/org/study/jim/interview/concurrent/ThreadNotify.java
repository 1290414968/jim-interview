package org.study.jim.interview.concurrent;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @Auther: jim
 * @Date: 2018/11/10 15:54
 * @Description:
 */
public class ThreadNotify extends Thread {
    private Lock lock;
    private Condition condition;

    public ThreadNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("开始执行 thread notify");
        try {
            condition.signal();
            System.out.println("执行结束 thread notify");
        } finally {
            lock.unlock();
        }
    }
}
