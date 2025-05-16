package com.java.base.Concurrency;

public class ThreadLock implements Runnable {
    static Object lockObject = new Object();

    public static void main(String[] args) {
        Runnable runnable = new ThreadLock();
        Thread thread = new Thread(
                    new Runnable() {

                        @Override
                        public void run()  {
                            synchronized (lockObject) {
                                System.out.println(Thread.currentThread().getName());
                            try {
                                lockObject.notify();
                                logicMethod();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            }
                        }

                }, "Thread-a");
        thread.start();
        Thread thread1 = new Thread(runnable, "Thread-b");
        thread1.start();
        Thread thread2 = new Thread(runnable, "Thread-c");
        thread2.start();

    }

    @Override
    public void run() {
       
        try {
            logicMethod();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Intrinsic Lock - by synchronized
    public static synchronized void logicMethod() throws InterruptedException {
                           
        // if (Thread.currentThread().getName().equalsIgnoreCase("thread-a")) {
        //     System.out.println(Thread.currentThread().getName());
        //        lockObject.notifyAll();
          
            
        // }
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
