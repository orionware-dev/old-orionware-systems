package core.reflection.services.enumerations.impl.tasks;

import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class GetEnumerationNameTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public static String run(Enum enumerationDefinition)
    {
        return enumerationDefinition.name();
    }
}