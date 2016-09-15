package reflection.enumerations.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetEnumerationNameTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public static String run(Enum enumerationDefinition)
    {
        return enumerationDefinition.name();
    }
}