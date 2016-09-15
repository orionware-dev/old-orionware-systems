package tester;

import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class JUnitRunnerBuilder extends RunnerBuilder
{
    public JUnitRunnerBuilder(Class<?> testClass)
    {
        try
        {
            runnerForClass(testClass);
        }
        catch(Throwable exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    @Override
    public Runner runnerForClass(Class<?> testClass) throws Throwable
    {
        Concurrency annotation = testClass.getAnnotation(Concurrency.class);
        
        if(annotation != null)
        {
            return new ConcurrentJUnitRunner(testClass);
        }
        
        return null;
    }
}