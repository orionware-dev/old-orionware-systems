package designpatterns.services.pipeline.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;

public class ExecuteFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
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
                    //function is nonlambda and it requires the actual
                    //class types to be passed to getDeclaredMethod()
                    if(filter.isCustomFunction())
                    {                        
                        classes[i] = filter.getFunctionParameters()[i].getClass();
                    }
                    //function is a lambda. If you use generics or Object
                    //as lambda input parameter then Object.class has to be
                    //passed as class type to getDeclaredMethod()
                    else
                    {
                        classes[i] = Object.class;
                    }
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