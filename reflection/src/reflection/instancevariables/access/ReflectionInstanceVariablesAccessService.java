package reflection.instancevariables.access;

import java.lang.reflect.Field;
import reflection.ReflectionService;

public interface ReflectionInstanceVariablesAccessService extends ReflectionService
{
    public void makeInstanceVariableAccessible(Field instanceVariable);
}