package core.libraries.tasks;

import core.configuration.CoreConfiguration;
import core.services.OrionTask;

public class IsCoreLibraryTask implements OrionTask
{
    public boolean run(Class<?> classBeingRun)
    {
        CoreConfiguration coreConfiguration = new CoreConfiguration();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb1.append(coreConfiguration.CLASSPATH_ROOT);
        sb1.append(".");
        sb2.append(coreConfiguration.INTEGRATION_TESTS_CLASSPATH_ROOT);
        sb2.append(".");
        sb3.append(coreConfiguration.UNIT_TESTS_CLASSPATH_ROOT);
        sb3.append(".");
        return classBeingRun.getName().startsWith(sb1.toString())
                    || classBeingRun.getName().startsWith(sb2.toString())
                    || classBeingRun.getName().startsWith(sb3.toString());
    }
}