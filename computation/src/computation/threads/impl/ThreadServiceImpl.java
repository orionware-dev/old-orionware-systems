package computation.threads.impl;

import java.util.concurrent.ThreadFactory;
import computation.threads.ThreadService;
import computation.threads.impl.tasks.GetNumberOfAvailableThreadsTask;

public class ThreadServiceImpl implements ThreadService
{
    @Override
    public int getNumberOfAvailableThreads(final Class<?> aClass)
    {
        return GetNumberOfAvailableThreadsTask.run(aClass);
    }


    @Override
    public ThreadFactory createNamedThread(String poolName)
    {
        return new ThreadFactoryServiceImpl(poolName);
    }
}