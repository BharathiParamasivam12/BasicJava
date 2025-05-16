package com.java.base.Threadcreation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableExecuter {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService  service = Executors.newSingleThreadExecutor();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                String threadName = Thread.currentThread().getName();
                return threadName;
            }
        };

        FutureTask<String> futureTask =  (FutureTask<String>) service.submit(callable); 

        System.out.println(futureTask.get());
        service.shutdown();
    }
}
