package core.configuration.tasks;

import java.io.File;
import core.configuration.Configuration;
import core.services.OrionTask;

public class GetConfigurationPathTask implements OrionTask
{
    private String libraryClasspathRootPath;
    
    
    public GetConfigurationPathTask(String libraryClasspathRootPath)
    {
        this.libraryClasspathRootPath = libraryClasspathRootPath;
    }
    
    
    @Override
    public Object execute(Object... methodParameters)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(new File((String)new GetClasspathRootTask(libraryClasspathRootPath).execute()).getAbsolutePath());
        sb.append("/");
        sb.append(Configuration.DEFAULT_CONFIGURATION_DIR);
        return sb.toString();
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}