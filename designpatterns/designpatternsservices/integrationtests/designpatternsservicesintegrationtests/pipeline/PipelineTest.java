package designpatternsservicesintegrationtests.pipeline;

import java.util.function.Consumer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import core.runnables.consumers.Consumer1;
import core.runnables.functions.Function1x1;
import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.PipelineService;
import designpatterns.services.pipeline.impl.PipelineFilterServiceImpl;
import designpatterns.services.pipeline.impl.PipelineServiceImpl;

public class PipelineTest extends DesignPatternsObject
{
    private PipelineFilterService pipelineFilterService;
    private PipelineService pipelineService;


    @Before
    public void setUp() throws Exception
    {
        this.pipelineFilterService = new PipelineFilterServiceImpl();
        this.pipelineService = new PipelineServiceImpl();
    }


    @Test
    public void testPipelineOfProcedures()
    {
        Consumer1<Integer> consumer = (Integer number) -> System.out.println("number = " + number);
        AbstractFilter filter = pipelineFilterService.createFilter(consumer, "run", 4);
        Consumer1<Integer> consumer2 = (Integer number) -> System.out.println("number2 = " + number);
        AbstractFilter filter2 = pipelineFilterService.createFilter(consumer2, "run", 6);
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline();
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        pipelineService.executeFilters(pipeline);
    }


    @Test
    public void testPipelineOfFunctions()
    {
        Function1x1<Integer, Integer> function = (Integer number) -> 2 * number;
        AbstractFilter filter = pipelineFilterService.createFilter(function, "run", 4);
        Function1x1<Integer, Integer> function2 = (Integer number) -> 2 * number + 3;
        AbstractFilter filter2 = pipelineFilterService.createFilter(function2, "run", 6);
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline();
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        Integer result = (Integer)pipelineService.executeFilters(pipeline);
        Assert.assertEquals("15", Integer.toString(result));
    }
    
    
    @Test
    public void testPipelineOfObjectFunction()
    {
        TestClass testClass = new TestClass();
        AbstractFilter filter = pipelineFilterService.createFilter(testClass, "printHello", "world!");
        Function1x1<Integer, Integer> function2 = (Integer number) -> 2 * number + 3;
        AbstractFilter filter2 = pipelineFilterService.createFilter(function2, "run", 6);
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline();
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        Integer result = (Integer)pipelineService.executeFilters(pipeline);
        Assert.assertEquals("15", Integer.toString(result));
    }
    
    
    @Test
    public void testPipelineOfProcedures2()
    {
        Consumer<?> action = (Integer number) -> System.out.println("new number = " + number);
        AbstractFilter filter = pipelineFilterService.createFilter(action, "accept", 9);
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline();
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.executeFilters(pipeline);
    }
    
    
    @Test
    public void testPipelineOfObjectFunction2()
    {
        Function1x1<Integer, Integer> function = (Integer number) -> 2 * number + 3;
        AbstractFilter filter = pipelineFilterService.createFilter(function, "run", 6);
        TestClass testClass = new TestClass();
        AbstractFilter filter2 = pipelineFilterService.createFilter(testClass, "printHello", "world!");
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline();
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        Integer result = (Integer)pipelineService.executeFilters(pipeline);
        Assert.assertEquals("15", Integer.toString(result));
    }
    
    
    @Test
    public void testPipelineOfChainFunctions()
    {
        Function1x1<Integer, Integer> function = (Integer number) -> 2 * number + 3;
        AbstractFilter filter = pipelineFilterService.createFilter(function, "run", 6);
        TestClass testClass = new TestClass();
        AbstractFilter filter2 = pipelineFilterService.createFilter(testClass, "printHello", "world!");
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline();
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        Integer result = (Integer)pipelineService.executeFilters(pipeline);
        Assert.assertEquals("15", Integer.toString(result));
    }
}