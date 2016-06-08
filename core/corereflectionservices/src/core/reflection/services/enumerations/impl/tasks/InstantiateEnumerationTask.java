package core.reflection.services.enumerations.impl.tasks;

import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;
import core.reflection.services.loader.impl.tasks.LoadClassTask;

public class InstantiateEnumerationTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Class<Enum> run(String enumerationPath)
    {
        return (Class<Enum>)LoadClassTask.run(enumerationPath);
    }
}