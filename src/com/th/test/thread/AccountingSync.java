package com.th.test.thread;

/**
 * 1.使用使用synchronized修饰实例对象时，如果一个线程正在访问实例对象的一个synchronized方法时，
 * 其它线程不仅不能访问该synchronized方法，该对象的其它synchronized方法也不能访问，
 * 因为一个对象只有一个监视器锁对象，但是其它线程可以访问该对象的非synchronized方法。
 *
 * 2.线程A访问实例对象的非static synchronized方法时，线程B也可以同时访问实例对象的static synchronized方法，
 * 因为前者获取的是实例对象的监视器锁，而后者获取的是类对象的监视器锁，两者不存在互斥关系。
 *
 *
 *
 **/
public class AccountingSync implements Runnable{
    //共享资源(临界资源)
    static int i=0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        System.out.println(Thread.currentThread().getName());
        i++;
    }

    public synchronized void increase2(){//如果加synchronized 那么与increase()也是互斥的  原因1
        i++;
    }

    public static synchronized void increase3(){//那么与increase()不互斥  原因2
        i++;
    }


    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
//            increase3();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}