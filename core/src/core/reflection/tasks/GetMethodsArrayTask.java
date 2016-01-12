package core.reflection.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.OrionObject;
import core.services.OrionTask;

public class GetMethodsArrayTask implements OrionTask
{
    private OrionObject object;
    
    
    public GetMethodsArrayTask(OrionObject object)
    {
        this.object = object;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
    {
        return null;
    }


    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return Arrays.stream(object.getClass().getDeclaredMethods())
                    .filter((method) -> method != null).toArray(Method[]::new);
    }
}