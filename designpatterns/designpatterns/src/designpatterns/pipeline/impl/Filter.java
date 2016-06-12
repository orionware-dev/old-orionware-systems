package designpatterns.pipeline.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.runnables.consumers.Consumer1;
import designpatterns.pipeline.AbstractFilter;

public class Filter extends AbstractFilter
{
    public Filter()
    {
        
    }
    
    
    public Filter(boolean isFunctionAProcedure, Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        super(isFunctionAProcedure, functionToExecute, methodToRun, functionParameters);
    }
    
    
    @Override
    public void run()
    {
        try
        {
            if(isFunctionAProcedure())
            {
                Class<?>[] classes = null;
                
                if(getFunctionParameters() != null)
                {
                    int numberOfFunctionParameters = getFunctionParameters().length;
                    
                    if(numberOfFunctionParameters > 0)
                    {
                        classes = new Class<?>[numberOfFunctionParameters];
                        
                        for(int i = 0; i < numberOfFunctionParameters; i++)
                        {
                            classes[i] = Object.class;
                        }
                    }
                }
                
                Method method = getFunctionClass().getDeclaredMethod(getMethodToRun(), classes);
                method.setAccessible(true);
                method.invoke(getFunction(), getFunctionParameters());
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
        catch(Throwable exception)
        {
            exception.printStackTrace();
        }
    }
}