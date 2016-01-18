package core.libraries.tasks;

import core.configuration.CoreConfiguration;
import core.services.OrionTask;

public class IsCoreLibraryTask implements OrionTask
{
    public boolean run(Class<?> classBeingRun)
    {
        return classBeingRun.getName().startsWith(CoreConfiguration.CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(CoreConfiguration.INTEGRATION_TESTS_CLASSPATH_ROOT + ".")
                    || classBeingRun.getName().startsWith(CoreConfiguration.UNIT_TESTS_CLASSPATH_ROOT + ".");
    }
}