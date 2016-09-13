package reflection.methods.access;

import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionMethodAccessService extends ReflectionService
{
    public void makeMethodAccessible(Method method);


    public Object callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);
}