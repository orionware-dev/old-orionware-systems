package computation.threads;

import java.util.concurrent.ThreadFactory;

public interface ThreadService
{
    public ThreadFactory createNamedThread(String poolName);
    
    
    public int getNumberOfAvailableThreads(final Class<?> aClass);
}