package core.libraries.tasks;

import core.configuration.CoreConfigurationEnum;
import core.services.OrionTask;

public class IsCoreLibraryTask implements OrionTask
{
    public boolean run(Class<?> classBeingRun)
    {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb1.append(CoreConfigurationEnum.CLASSPATH_ROOT.get());
        sb1.append(".");
        sb2.append(CoreConfigurationEnum.INTEGRATION_TESTS_CLASSPATH_ROOT.get());
        sb2.append(".");
        sb3.append(CoreConfigurationEnum.UNIT_TESTS_CLASSPATH_ROOT.get());
        sb3.append(".");
        return classBeingRun.getName().startsWith(sb1.toString())
                    || classBeingRun.getName().startsWith(sb2.toString())
                    || classBeingRun.getName().startsWith(sb3.toString());
    }
}