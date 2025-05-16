package com.java.base.Concurrency;

import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantSample {
    static ReentrantLock lock = new ReentrantLock();
    
        public static void main(String[] args) {
       
            File file = new File("/Downloads/xyz");
            System.out.println(file.exists());
            if(file.canRead()){
                lock.lock();
                    System.out.println("Count main : " +lock.getHoldCount());
                     doSomethingOnFile(file);
                if(file.isFile()){
                  doSomethingOnFile(file);
                  lock.unlock();
            }
        }
    }

    public static void doSomethingOnFile(File file){
        lock.lock();
        if(file.exists()){
            file.delete();
            lock.unlock();
        }
       System.out.println("Count inside logic file method: " +lock.getHoldCount());
    }
}
