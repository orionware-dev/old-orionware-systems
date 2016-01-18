package core.configuration.tasks;

import java.io.File;
import core.configuration.CoreConfiguration;
import core.services.OrionTask;

public class GetClasspathRootPathTask implements OrionTask
{
    public String run(String libraryClasspathRootPath)
    {
        //use this class to get the path of this class
        File classpathRoot = new File(this.getClass().getResource("").getPath());
        
        //get parent dir until we reach the classpath root which is the "core" dir
        do
        {
            classpathRoot = new File(classpathRoot.getParent());
            
            if(!CoreConfiguration.CLASSPATH_ROOT.equals(libraryClasspathRootPath)
                && classpathRoot.getAbsolutePath().endsWith(File.separator + CoreConfiguration.CLASSPATH_ROOT))
            {
                classpathRoot = new File(classpathRoot.getParent());
                
                if(classpathRoot.getAbsolutePath().endsWith(CoreConfiguration.CLASSPATH_ROOT + File.separator + CoreConfiguration.BIN_DIR))
                {
                    classpathRoot = new File(classpathRoot.getParent());
                    classpathRoot = new File(classpathRoot.getParent());
                    classpathRoot = new File(classpathRoot.getAbsolutePath() + File.separator + libraryClasspathRootPath + File.separator + CoreConfiguration.BIN_DIR + File.separator + libraryClasspathRootPath);
                }
                else
                {
                    classpathRoot = new File(classpathRoot.getAbsolutePath() + File.separator + libraryClasspathRootPath);
                }
                
                break;
            }
        }
        while(!classpathRoot.getName().endsWith(libraryClasspathRootPath));
        
        return classpathRoot.getAbsolutePath();
    }
}