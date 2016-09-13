package reflection.enumerations.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.classes.impl.ReflectionClassesServiceImpl;

public class InstantiateEnumerationTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Class<Enum> run(String enumerationPath)
    {
        return (Class<Enum>)new ReflectionClassesServiceImpl().loadClass(enumerationPath);
    }
}