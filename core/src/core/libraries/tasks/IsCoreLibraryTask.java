package core.libraries.tasks;

import core.configuration.CoreConfiguration;
import core.services.OrionTask;

public class IsCoreLibraryTask implements OrionTask
{
    public Object run(Class<?> classBeingRun)
    {
        return classBeingRun.getName().startsWith(CoreConfiguration.CORE_CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(CoreConfiguration.CORE_INTEGRATION_TESTS_CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(CoreConfiguration.CORE_UNIT_TESTS_CLASSPATH_ROOT + ".");
    }
}