package com.java.base.Threadcreation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableFuture {
    public static void main(String[] args) throws Exception {

        //create callable instance FI
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
              return "Hi hello ";
            }
        };

        //Wrapped up with FutureTask because Thread class doenst support callable

       FutureTask futureTask = new FutureTask<>(callable);

       // Create a thread and pass future task because it accepts Runnable in constructor

       Thread thread = new Thread(futureTask);
       thread.start();

       //Get Resultset 

       String out = (String) futureTask.get();
       System.err.println(out);
    }
}
