package core.libraries.tasks;

import core.configuration.Configuration;
import core.services.OrionTask;

public class IsCoreLibraryTask implements OrionTask
{
    private Class<?> classBeingRun;
    
    
    public IsCoreLibraryTask(Class<?> classBeingRun)
    {
        this.classBeingRun = classBeingRun;
    }
    

    @Override
    public Object execute(Object... methodParameters)
    {
        return classBeingRun.getName().startsWith(Configuration.CORE_CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(Configuration.CORE_INTEGRATION_TESTS_CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(Configuration.CORE_UNIT_TESTS_CLASSPATH_ROOT + ".");
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}