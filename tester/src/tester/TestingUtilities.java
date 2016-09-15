package tester;

public class TestingUtilities
{
    public static int getNumberOfThreadsToUse(final Class<?> aClass)
    {
        if(aClass.isAnnotationPresent(Concurrency.class))
        {
            return aClass.getAnnotation(Concurrency.class).threads();
        }
        
        return Runtime.getRuntime().availableProcessors();
    }
}