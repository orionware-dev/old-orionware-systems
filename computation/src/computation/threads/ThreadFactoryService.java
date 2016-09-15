package computation.threads;

import java.util.concurrent.ThreadFactory;

public interface ThreadFactoryService extends ThreadFactory
{
    @Override
    public Thread newThread(Runnable runnable);
}