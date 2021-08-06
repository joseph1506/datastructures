package threading;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{
    BlockingQueue taskQueue;
    boolean isStopped=false;
    Thread thread;

    public PoolThreadRunnable(BlockingQueue taskQueue) {
        this.taskQueue=taskQueue;
    }

    @Override
    public void run() {
        this.thread=Thread.currentThread();
        while(!isStopped){
            try {
                Runnable task = (Runnable) taskQueue.take();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doStop() {
        isStopped=true;
        this.thread.interrupt();
    }
}
