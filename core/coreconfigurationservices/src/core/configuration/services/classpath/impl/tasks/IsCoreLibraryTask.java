package core.configuration.services.classpath.impl.tasks;

import java.io.File;
import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;

public class IsCoreLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public boolean run(Class<?> classBeingRun)
    {
        File classpathRoot = new File(classBeingRun.getResource("").getPath());
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        sb.append("core");
        sb.append(File.separator);
        sb.append("core");
        
        if(classpathRoot.getAbsolutePath().indexOf(sb.toString()) != -1)
        {
            return true;
        }
        
        return false;
    }
    
    
    public boolean run(Object objectBeingRun)
    {
        return run(objectBeingRun.getClass());
    }
}