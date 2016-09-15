package computation.threads.impl.tasks;

import computation.annotation.Concurrency;

public class GetNumberOfAvailableThreadsTask
{
    public static int run(final Class<?> aClass)
    {
        if(aClass.isAnnotationPresent(Concurrency.class))
        {
            return aClass.getAnnotation(Concurrency.class).threads();
        }
        
        return Runtime.getRuntime().availableProcessors();
    }
}