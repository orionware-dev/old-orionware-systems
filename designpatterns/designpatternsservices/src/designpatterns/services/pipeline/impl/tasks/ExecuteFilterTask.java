package designpatterns.services.pipeline.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.ProceduralFilter;
import designpatterns.services.DesignPatternsServicesObject;

public class ExecuteFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public Object run(AbstractFilter filter)
    {
        Class<?>[] classes = null;
        
        if(filter.getFunctionParameters() != null)
        {
            int numberOfFunctionParameters = filter.getFunctionParameters().length;
            
            if(numberOfFunctionParameters > 0)
            {
                classes = new Class<?>[numberOfFunctionParameters];
                
                for(int i = 0; i < numberOfFunctionParameters; i++)
                {
                    classes[i] = Object.class;
                }
            }
        }
        
        try
        {
            Method method = filter.getFunctionClass().getDeclaredMethod(filter.getMethodToRun(), classes);
            method.setAccessible(true);
            
            try
            {
                Object functionResult = method.invoke(filter.getFunction(), filter.getFunctionParameters());
                filter.setFunctionResult(functionResult);
            }
            catch(IllegalAccessException exception)
            {
                exception.printStackTrace();
            }
            catch(IllegalArgumentException exception)
            {
                exception.printStackTrace();
            }
            catch(InvocationTargetException exception)
            {
                exception.printStackTrace();
            }
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        
        return filter.getFunctionResult();
    }
}