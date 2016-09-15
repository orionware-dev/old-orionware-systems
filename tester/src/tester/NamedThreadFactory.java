package tester;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory
{
    static final AtomicInteger poolNumber = new AtomicInteger(1);
    final AtomicInteger threadNumber = new AtomicInteger(1);
    final ThreadGroup group;


    public NamedThreadFactory(String poolName)
    {
        this.group = new ThreadGroup(poolName + "-" + poolNumber.getAndIncrement());
    }


    @Override
    public Thread newThread(Runnable runnable)
    {
        return new Thread(group, runnable, group.getName() + "-thread-" + threadNumber.getAndIncrement(), 0);
    }
}