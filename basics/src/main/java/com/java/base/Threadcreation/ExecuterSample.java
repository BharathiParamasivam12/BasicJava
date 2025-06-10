package com.java.base.Threadcreation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecuterSample {
  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(5);
    AtomicInteger count;

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        display();
      }
    };

    // service.execute(runnable);
    // service.submit(runnable,"done" );

    for (int i = 0; i <= 3; i++) {
      service.submit(runnable);
    }
    service.shutdown();

  }

  public synchronized static void display() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " - " + Thread.currentThread().getState());
    }
  }
}
