package me.homework.server.workers;

import me.homework.server.helpers.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Mihail on 10/24/2015.
 */
public class ExecutorMonitor implements Runnable {

    private final static String TAG = "me.homework.server.workers.ExecutorMonitor";

    private ThreadPoolExecutor executor;

    public ExecutorMonitor(ThreadPoolExecutor pool) {
        this.executor = pool;
    }

    public void run() {
        try {
            do {
                Logger.info(TAG, String.format("[%d/%d] Active: %d, Completed: %d, Task: %d, queueSize: %d",
                        executor.getPoolSize(),
                        executor.getCorePoolSize(),
                        executor.getActiveCount(),
                        executor.getCompletedTaskCount(),
                        executor.getTaskCount(),
                        executor.getQueue().size()));
                Thread.sleep(10000);
            } while (true);
        } catch (InterruptedException e) {
            Logger.error(TAG, e.getMessage());
        }
    }
}
