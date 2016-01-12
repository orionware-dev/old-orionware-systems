package core.configuration.tasks;

import java.io.File;
import core.configuration.Configuration;
import core.services.OrionTask;

public class GetConfigurationPathTask extends OrionTask
{
    public Object execute(String libraryClasspathRootPath, GetClasspathRootTask getClasspathRootTask)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(new File((String)getClasspathRootTask.execute(libraryClasspathRootPath)).getAbsolutePath());
        sb.append("/");
        sb.append(Configuration.DEFAULT_CONFIGURATION_DIR);
        return sb.toString();
    }
}