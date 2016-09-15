package tester;

import java.util.Arrays;
import java.util.List;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class AllJUnitRunnerBuilder extends AllDefaultPossibilitiesBuilder
{
    public AllJUnitRunnerBuilder(boolean canUseSuiteMethod)
    {
        super(canUseSuiteMethod);
    }
    
    
    @Override
    public Runner runnerForClass(Class<?> testClass) throws Throwable
    {
        List<RunnerBuilder> runnerBuilders = Arrays.asList(new JUnitRunnerBuilder(testClass), ignoredBuilder(), annotatedBuilder(), suiteMethodBuilder(), junit3Builder(), junit4Builder());
        
        for(RunnerBuilder runnerBuilder : runnerBuilders)
        {
            Runner runner = runnerBuilder.safeRunnerForClass(testClass);
            
            if(runner != null)
            {
                return runner;
            }
        }
        
        return null;
    }
}