package tester;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

public final class ConcurrentSuite extends Suite
{
    public ConcurrentSuite(final Class<?> aClass) throws InitializationError
    {
        super(aClass, new AllJUnitRunnerBuilder(true));
        setScheduler(new JUnitTestRunnerScheduler(aClass));
    }
}