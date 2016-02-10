package core.configuration.classpath.tasks;

import core.configuration.OrionConfigurationTask;
import core.configuration.CoreConfigurationEnum;

public class IsCoreLibraryTask implements OrionConfigurationTask
{
    private StringBuilder sb1 = new StringBuilder();
    
    
    public boolean run(Class<?> classBeingRun)
    {
        sb1.append(CoreConfigurationEnum.CLASSPATH_ROOT.get());
        sb1.append(".");
        return classBeingRun.getName().startsWith(sb1.toString());
    }
}