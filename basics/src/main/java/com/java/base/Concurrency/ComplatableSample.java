package com.java.base.Concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplatableSample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> completableFutRunnable = CompletableFuture.runAsync(
            ()-> {
                System.out.println("Iam calling run method of Runnable I/F");
            }
        );

        CompletableFuture<String> completableFutureSupplier = CompletableFuture.supplyAsync(
            () -> {
                return "Hi am in suuply method of callable future";
            }
        );

        CompletableFuture<String> completeJoin = completableFutureSupplier.thenApply(
                input -> input.concat(" am joining you")
            
        );
            
        System.out.println(completableFutureSupplier.get());
        System.out.println(completeJoin.get());
        System.out.println(completeJoin.thenAccept(result -> System.out.println("Output : "+result)));
    }
}
