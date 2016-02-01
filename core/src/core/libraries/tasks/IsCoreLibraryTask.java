package core.libraries.tasks;

import core.configuration.CoreConfigurationEnum;
import core.services.OrionTask;

public class IsCoreLibraryTask implements OrionTask
{
    private StringBuilder sb1 = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    private StringBuilder sb3 = new StringBuilder();
    
    
    public boolean run(Class<?> classBeingRun)
    {
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