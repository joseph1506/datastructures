package asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class Sample2 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(intGenerate);
        future
                //.thenApply(data-> data * 2)
                //.thenAccept(data-> printIt(data));
        .exceptionally(throwable -> {
            System.out.println(throwable);
            return 0;
        });

        System.out.println(future.isDone());
        future.complete(7);
        System.out.println(future.isDone());
    }


    public static void printIt(Integer value) {
        System.out.println(value+" "+Thread.currentThread());
    }

    public static Supplier<Integer> intGenerate = ()->{
        //System.out.println("Doing work "+ Thread.currentThread());
        throw new RuntimeException("something wrong");
        //return 2;
    };
}
