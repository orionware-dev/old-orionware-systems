package core.configuration.tasks;

import java.io.File;
import core.configuration.Configuration;
import core.services.OrionTask;

public class GetConfigurationPathTask extends OrionTask
{
    public Object run(String libraryClasspathRootPath, GetClasspathRootTask getClasspathRootTask)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(new File((String)getClasspathRootTask.run(libraryClasspathRootPath)).getAbsolutePath());
        sb.append("/");
        sb.append(Configuration.DEFAULT_CONFIGURATION_DIR);
        return sb.toString();
    }
}