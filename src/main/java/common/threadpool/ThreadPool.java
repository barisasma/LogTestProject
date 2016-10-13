package common.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    
    private static ThreadPool instance = null;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    
    public static ThreadPool getInstance(){
        
        if(instance==null)
            instance = new ThreadPool();
        
        return instance;
        
    }

    
    public ExecutorService getExecutorService(){
        
        return executorService;
        
    }
}
