package core.libraries.tasks;

import core.configuration.Configuration;
import core.services.OrionTask;

public class IsCoreLibraryTask implements OrionTask
{
    public Object run(Class<?> classBeingRun)
    {
        return classBeingRun.getName().startsWith(Configuration.CORE_CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(Configuration.CORE_INTEGRATION_TESTS_CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(Configuration.CORE_UNIT_TESTS_CLASSPATH_ROOT + ".");
    }
}