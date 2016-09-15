package computation.threads.impl;

import java.util.concurrent.atomic.AtomicInteger;
import computation.threads.ThreadFactoryService;

public class ThreadFactoryServiceImpl implements ThreadFactoryService
{
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private ThreadGroup group;
    
    
    public ThreadFactoryServiceImpl(String poolName)
    {
        this.group = new ThreadGroup(poolName + "-" + poolNumber.getAndIncrement());
    }
    
    
    @Override
    public Thread newThread(Runnable runnable)
    {
        return new Thread(group, runnable, group.getName() + "-thread-" + threadNumber.getAndIncrement(), 0);
    }
}