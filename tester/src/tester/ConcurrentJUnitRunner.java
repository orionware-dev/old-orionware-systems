package tester;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class ConcurrentJUnitRunner extends BlockJUnit4ClassRunner
{
    public ConcurrentJUnitRunner(final Class<?> aClass) throws InitializationError
    {
        super(aClass);
        setScheduler(new JUnitTestRunnerScheduler(aClass));
    }
}