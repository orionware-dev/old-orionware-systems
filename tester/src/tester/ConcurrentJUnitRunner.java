package tester;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentJUnitRunner extends BlockJUnit4ClassRunner
{
    public ConcurrentJUnitRunner(final Class<?> aClass) throws InitializationError
    {
        super(aClass);
        setScheduler(new JUnitTestRunnerScheduler(aClass));
    }
}