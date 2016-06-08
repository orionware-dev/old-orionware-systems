package core.reflection.services.enumerations.impl.tasks;

import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;
import core.reflection.services.loader.impl.tasks.LoadClassTask;

public class InstantiateEnumerationTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Class<Enum> run(String enumerationPath)
    {
        return (Class<Enum>)new LoadClassTask().run(enumerationPath);
    }
}