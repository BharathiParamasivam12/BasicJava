package com.java.base.Concurrency;

public class Synchronization implements Runnable{

    static Object object = new Object();
    static volatile Boolean condition = false;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Synchronization();
        Thread thread = new Thread(runnable, "Thread -A");
        Thread thread1 = new Thread(runnable, "THREAD-B");
        Thread thread2 = new Thread(runnable, "THREAD-C");
        thread.start();
        thread1.start();
        thread2.start();
        Thread.sleep(100);

        Thread thread4 = new Thread( 
            new Runnable() {
                @Override
                public void run() {
                  synchronized(object){
                    condition = true;
                    object.notify();
                  }
                    try {
                        lockMyObject();
                        System.err.println("hi my name is "+Thread.currentThread().getName());
    
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                }
            }, "THREAD-D"
        );
     
        Thread thread5 = new Thread( 
            ()-> {
            synchronized(object){
                condition = true;
                object.notify();
            }
                try {
                    lockMyObject();
                    System.err.println("hi my name is "+Thread.currentThread().getName());
    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "THREAD-E"
        );
        thread4.start();
        thread5.start();
    }
  public static synchronized void lockMyObject() throws InterruptedException {
    synchronized (object) {
        System.out.println(Thread.currentThread().getName() + " entered lockMyObject()");
        while (!condition) {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            object.wait();
            System.out.println(Thread.currentThread().getName() + " resumed from wait");
        } 
            System.out.println(Thread.currentThread().getName() + " is notifying others...");
        }
    
}

      

   
    public void run() {
       try {
        lockMyObject();
       } catch (InterruptedException e) {
        e.printStackTrace();
       }
    }


}
