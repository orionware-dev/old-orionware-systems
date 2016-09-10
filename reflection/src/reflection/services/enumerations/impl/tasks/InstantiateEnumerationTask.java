package reflection.services.enumerations.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.services.accessibleobjects.classes.impl.tasks.LoadClassTask;

public class InstantiateEnumerationTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Class<Enum> run(String enumerationPath)
    {
        return (Class<Enum>)new LoadClassTask().run(enumerationPath);
    }
}