package asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class Sample {

    public static void main(String[] args) throws Exception {
        //testMain1();
        testMain2();
    }

    public static void testMain2() {
        CompletableFuture.supplyAsync(intGenerate)
                .thenApply(data-> data* 2)
            .thenAccept(Sample::printIt);
    }

    public static void testMain1() throws InterruptedException {
        ForkJoinPool pool1 = new ForkJoinPool(50);
        ForkJoinPool pool2 = new ForkJoinPool(10);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Sample.intGenerate,pool1);
        Thread.sleep(2000);
        future.thenAcceptAsync(value-> Sample.printIt(value),pool2);
        //Thread.sleep(5000);
        System.out.println("Main Ended");
    }

    public static void printIt(Integer value) {
        System.out.println(value+" "+Thread.currentThread());
    }

    public static Supplier<Integer> intGenerate = ()->{
        System.out.println("Doing work "+ Thread.currentThread());
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return 2;
    };


}
