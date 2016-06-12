package designpatterns.pipeline.filter;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.runnables.consumers.Consumer1;
import designpatterns.pipeline.AbstractFilter;

public class ProceduralFilter extends AbstractFilter
{
    public ProceduralFilter()
    {
        
    }
    
    
    public ProceduralFilter(Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        super(true, functionToExecute, methodToRun, functionParameters);
    }
}