package threading;

import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private BlockingQueue taskQueue;
    private List<PoolThreadRunnable> runnables;
    private boolean isStopped=false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        this.taskQueue = new ArrayBlockingQueue(maxNoOfTasks);
        runnables= new ArrayList<>();
        for(int i=0;i<noOfThreads;i++){
            PoolThreadRunnable poolThreadRunnable= new PoolThreadRunnable(taskQueue);
            runnables.add(poolThreadRunnable);
        }
        runnables.stream()
                .forEach(rc-> startRc(rc));
    }

    private void startRc(PoolThreadRunnable rc) {
        new Thread(rc).start();
    }

    public synchronized void execute(Runnable task){
        if(isStopped){
            throw new IllegalStateException("Thread Pool is stopped");
        }
        this.taskQueue.offer(task);
    }

    public void stop(){
        this.isStopped=true;
        runnables.stream()
                .forEach(this::stopRc);
    }

    private void stopRc(PoolThreadRunnable rc) {
        rc.doStop();
    }

    public void waitTillAllTasksAreFinished(){
        while(taskQueue.isEmpty()){
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
