package designpatternsintegrationtests.pipeline;

import java.util.function.Consumer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import core.runnables.consumers.Consumer1;
import core.runnables.functions.Function1x1;
import designpatterns.DesignPatternsObject;
import designpatterns.annotation.EmptyFilter;
import designpatterns.annotation.EmptyPipeline;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineFilterService;
import designpatterns.pipeline.PipelineService;
import designpatterns.pipeline.impl.PipelineFilterServiceImpl;
import designpatterns.pipeline.impl.PipelineServiceImpl;
import tester.Concurrent;
import tester.ConcurrentJunitRunner;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 4)
public class PipelineTest extends DesignPatternsObject
{
    private PipelineFilterService pipelineFilterService;
    private PipelineService pipelineService;
    @EmptyFilter
    private AbstractFilter emptyFilter;
    @EmptyPipeline(feedForwardTheResult = true)
    private AbstractPipeline emptyPipeline;


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
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline(false);
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
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline(false);
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
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline(false);
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        Integer result = (Integer)pipelineService.executeFilters(pipeline);
        Assert.assertEquals("15", Integer.toString(result));
    }


    @Test
    public void testPipelineOfJavaProcedures()
    {
        Consumer<?> action = (Integer number) -> System.out.println("new number = " + number);
        AbstractFilter filter = pipelineFilterService.createFilter(action, "accept", 9);
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline(false);
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
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline(false);
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        pipelineService.executeFilters(pipeline);
    }


    @Test
    public void testPipelineOfFeedForwardFunctions()
    {
        Function1x1<Integer, Integer> function = (Integer number) -> 2 * number + 3;
        AbstractFilter filter = pipelineFilterService.createFilter(function, "run", 6);
        Function1x1<Integer, Integer> function2 = (Integer number) -> 2 * number + 3;
        AbstractFilter filter2 = pipelineFilterService.createFilter(function2, "run");
        AbstractPipeline pipeline = pipelineService.createEmptyPipeline(true);
        pipelineService.addFilterToPipeline(pipeline, filter);
        pipelineService.addFilterToPipeline(pipeline, filter2);
        Integer result = (Integer)pipelineService.executeFilters(pipeline);
        Assert.assertEquals("33", Integer.toString(result));
    }


    @Test
    public void testEmptyFilterAnnotation()
    {
        Assert.assertNotNull(emptyFilter);
    }


    @Test
    public void testEmptyPipelineAnnotation()
    {
        Assert.assertNotNull(emptyPipeline);
        Assert.assertTrue(emptyPipeline.isFeedForwardTheResult());
    }


    /*@EmptyFilter
    private void setEmptyFilter(AbstractFilter emptyFilter)
    {
        this.emptyFilter = emptyFilter;
    }


    @EmptyPipeline(feedForwardTheResult = true)
    private void setEmptyPipeline(AbstractPipeline emptyPipeline)
    {
        this.emptyPipeline = emptyPipeline;
    }*/
}