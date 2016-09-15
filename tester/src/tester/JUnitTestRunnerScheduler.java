package tester;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.runners.model.RunnerScheduler;

public class JUnitTestRunnerScheduler implements RunnerScheduler
{
    private ExecutorService executorService;
    private CompletionService<Void> completionService;
    private Queue<Future<Void>> tasks;
    
    
    public JUnitTestRunnerScheduler(final Class<?> aClass)
    {
        int numberOfThreadsToUse = TestingUtilities.getNumberOfThreadsToUse(aClass);
        this.executorService = Executors.newFixedThreadPool(numberOfThreadsToUse, new NamedThreadFactory(aClass.getSimpleName()));
        this.completionService = new ExecutorCompletionService<Void>(executorService);
        this.tasks = new LinkedList<Future<Void>>();
    }
    
    
    @Override
    public void schedule(Runnable paramRunnable)
    {
        this.tasks.offer(completionService.submit(paramRunnable, null));
    }

    
    @Override
    public void finished()
    {
        try
        {
            while(!tasks.isEmpty())
            {
                tasks.remove(completionService.take());
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        finally
        {
            while(!tasks.isEmpty())
            {
                tasks.poll().cancel(true);
            }
            
            executorService.shutdownNow();
        }
    }
}