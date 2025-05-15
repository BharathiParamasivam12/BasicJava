package com.java.base;

import java.util.concurrent.Callable;

public class ThreadLamda{
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
        } );
        thread.start();

        Thread t1 = new Thread(
            new Runnable() {
                @Override
                public void run() {
                  System.out.println(Thread.currentThread().getName());
                    
                }
            }
        );
        t1.start();
    }
  }

