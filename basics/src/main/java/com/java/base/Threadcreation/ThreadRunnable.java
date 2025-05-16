package com.java.base.Threadcreation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThreadRunnable implements Runnable{

    public static void main(String[] args) {
        ThreadRunnable runnable = new ThreadRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

      Runnable runnable2 = new ThreadRunnable();
      Thread t = new Thread(runnable2);
      t.start();
    }


     
    public synchronized static void doLogic(){
          try {
            FileInputStream fileInputStream = new FileInputStream("/Downloads/xyz");
            if(fileInputStream.read()==1){
                System.err.println("true");
            }else{
                System.out.println("False");
            }

        } catch (IOException e) {
           System.out.println("No file found");
        }
    }

       @Override
        public void run() {
             doLogic();
        }
    
    
}
