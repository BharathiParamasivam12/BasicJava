package com.java.base.Concurrency;

public class VirtualThreadSample {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            // Thread.startVirtualThread(() -> {
            //     try {
            //         Thread.sleep(100); // still non-blocking for virtual thread
            //         System.out.println("Thread: " + Thread.currentThread());
            //     } catch (InterruptedException e) {
            //         e.printStackTrace();
            //     }
            // });
            System.out.println("hi");
        }
        Thread.sleep(500); // wait for all virtual threads to finish
    }
}

