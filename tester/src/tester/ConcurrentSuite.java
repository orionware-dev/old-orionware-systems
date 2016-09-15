package tester;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.RunnerScheduler;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConcurrentSuite extends Suite
{
    public ConcurrentSuite(final Class<?> aClass) throws InitializationError
    {
        super(aClass, new AllJUnitRunnerBuilder(true));
        setScheduler(new JUnitTestRunnerScheduler(aClass));
    }
}