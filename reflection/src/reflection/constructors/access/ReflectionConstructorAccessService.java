package reflection.constructors.access;

import java.lang.reflect.Constructor;
import reflection.ReflectionService;

public interface ReflectionConstructorAccessService extends ReflectionService
{
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments);
}