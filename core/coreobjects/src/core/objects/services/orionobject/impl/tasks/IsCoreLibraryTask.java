package core.objects.services.orionobject.impl.tasks;

import java.io.File;

public class IsCoreLibraryTask
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
}