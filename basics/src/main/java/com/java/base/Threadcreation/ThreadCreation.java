package com.java.base.Threadcreation;

public class ThreadCreation extends Thread{
    public static void main(String[] args) {
       ThreadCreation t1 = new ThreadCreation();
       t1.start();

    
    }
    public void display(){
        System.out.println(Thread.currentThread().getName());
    }


    @Override
    public void run(){
        display();
    }
}
