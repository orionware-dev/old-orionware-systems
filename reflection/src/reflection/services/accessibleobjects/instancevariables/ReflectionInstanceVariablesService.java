package reflection.services.accessibleobjects.instancevariables;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionInstanceVariablesService extends ReflectionService
{
    public Field[] getInstanceVariablesArray(Object object);
    
    
    public Field[] getInstanceVariablesArray(Class<?> aClass);
    
    
    public void makeInstanceVariableAccessible(Field instanceVariable);
}