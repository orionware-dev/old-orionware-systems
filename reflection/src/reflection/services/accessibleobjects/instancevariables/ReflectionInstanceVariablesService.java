package reflection.services.accessibleobjects.instancevariables;

import java.lang.reflect.Field;
import reflection.ReflectionService;

public interface ReflectionInstanceVariablesService extends ReflectionService
{
    public Field[] getInstanceVariablesArray(Object object);
    
    
    public Field[] getInstanceVariablesArray(Class<?> aClass);
    
    
    public void makeInstanceVariableAccessible(Field instanceVariable);
}