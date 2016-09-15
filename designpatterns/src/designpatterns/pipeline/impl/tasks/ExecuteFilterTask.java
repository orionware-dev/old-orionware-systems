package designpatterns.pipeline.impl.tasks;

import java.lang.reflect.Method;
import dependencyinjection.annotation.InjectorImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.retrieval.ReflectionMethodRetrievalService;

public class ExecuteFilterTask extends DesignPatternsObject implements DesignPatternsTask
{
    @InjectorImpl
    private static ReflectionMethodRetrievalService reflectionMethodRetrievalService;
    @InjectorImpl
    private ReflectionMethodAccessService reflectionMethodAccessService;
    
    
    public Object run(AbstractFilter filter, Object functionInput)
    {
        Class<?>[] classes = null;

        if(functionInput != null)
        {
            filter.setFunctionParameters(new Object[]{functionInput});
        }

        if(filter.getFunctionParameters() != null)
        {
            int numberOfFunctionParameters = filter.getFunctionParameters().length;

            if(numberOfFunctionParameters > 0)
            {
                classes = new Class<?>[numberOfFunctionParameters];

                for(int i = 0; i < numberOfFunctionParameters; i++)
                {
                    // function is nonlambda and it requires the actual
                    // class types to be passed to getDeclaredMethod()
                    if(filter.isCustomFunction())
                    {
                        classes[i] = filter.getFunctionParameters()[i].getClass();
                    }
                    // function is a lambda. If you use generics or Object
                    // as lambda input parameter then Object.class has to be
                    // passed as class type to getDeclaredMethod()
                    else
                    {
                        classes[i] = Object.class;
                    }
                }
            }
        }

        try
        {
            Method method = reflectionMethodRetrievalService.getDeclaredMethod(filter.getMethodToRun(), filter.getFunctionClass(), classes);
            reflectionMethodAccessService.makeMethodAccessible(method);

            try
            {
                Object functionResult = reflectionMethodAccessService.callMethod(method, filter.getFunction(), filter.getFunctionParameters());
                filter.setFunctionResult(functionResult);
            }
            catch(IllegalArgumentException exception)
            {
                exception.printStackTrace();
            }
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }

        return filter.getFunctionResult();
    }
}