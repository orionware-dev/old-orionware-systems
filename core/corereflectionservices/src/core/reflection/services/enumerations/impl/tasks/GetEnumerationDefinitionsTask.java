package core.reflection.services.enumerations.impl.tasks;

import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class GetEnumerationDefinitionsTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public Enum[] run(Class<Enum> enumerationClass)
    {
        return enumerationClass.getEnumConstants();
    }
}