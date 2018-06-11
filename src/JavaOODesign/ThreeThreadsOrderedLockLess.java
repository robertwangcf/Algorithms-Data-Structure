package JavaOODesign;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Question: print out numbers in sequence with different thread
 */
public class ThreeThreadsOrderedLockLess {

    AtomicInteger sharedOutput = new AtomicInteger(0);
    private Object object = new Object();
    public static void main(String args[]) throws InterruptedException{
        ThreeThreadsOrderedLockLess t = new ThreeThreadsOrderedLockLess();
        MyThread t1 = t.new MyThread(0);
        MyThread t2 = t.new MyThread(1);
        MyThread t3 = t.new MyThread(2);

        Thread ts1 = new Thread(t1);
        Thread ts2 = new Thread(t2);
        Thread ts3 = new Thread(t3);
        ts1.setName("Thread1");
        ts2.setName("Thread2");
        ts3.setName("Thread3");
        ts1.start();
        ts2.start();
        ts3.start();


    }

    private class MyThread implements Runnable{
        private ReentrantLock lock;
        private final int threadPosition;
        public MyThread(int threadPosition) {
            super();
            this.threadPosition = threadPosition;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (sharedOutput.get() < 5) {
                    synchronized (object) {
                        System.out.println(Thread.currentThread()+"  "+
                                sharedOutput.incrementAndGet());
                    }
                }
            } finally {
                lock.unlock();
            }

        }
    }

   /* private class SerialExecutor implements Executor {
        final Queue<MyThread> tasks = new ArrayDeque<>();
        Runnable active;
        public synchronized void execute(final Runnable r) {
            MyThread r1 = tasks.poll();
             tasks.offer(r1);

            try
            {
                r1.run();
            } finally {
                scheduleNext();
            }

        }
    }*/
}

