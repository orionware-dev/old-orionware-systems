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
        StringBuilder sb = null;
        
        //get parent dir until we reach the classpath root which is the "core" dir
        do
        {
            classpathRoot = new File(classpathRoot.getParent());
            sb = new StringBuilder();
            sb.append(File.separator);
            sb.append(CoreConfiguration.CLASSPATH_ROOT);
            
            if(!CoreConfiguration.CLASSPATH_ROOT.equals(libraryClasspathRootPath)
                && classpathRoot.getAbsolutePath().endsWith(sb.toString()))
            {
                classpathRoot = new File(classpathRoot.getParent());
                sb = new StringBuilder();
                sb.append(CoreConfiguration.CLASSPATH_ROOT);
                sb.append(File.separator);
                sb.append(CoreConfiguration.BIN_DIR);
                
                if(classpathRoot.getAbsolutePath().endsWith(sb.toString()))
                {
                    classpathRoot = new File(classpathRoot.getParent());
                    classpathRoot = new File(classpathRoot.getParent());
                    sb = new StringBuilder();
                    sb.append(classpathRoot.getAbsolutePath());
                    sb.append(File.separator);
                    sb.append(libraryClasspathRootPath);
                    sb.append(File.separator);
                    sb.append(CoreConfiguration.BIN_DIR);
                    sb.append(File.separator);
                    sb.append(libraryClasspathRootPath);
                    classpathRoot = new File(sb.toString());
                }
                else
                {
                    sb = new StringBuilder();
                    sb.append(classpathRoot.getAbsolutePath());
                    sb.append(File.separator);
                    sb.append(libraryClasspathRootPath);
                    classpathRoot = new File(sb.toString());
                }
                
                break;
            }
        }
        while(!classpathRoot.getName().endsWith(libraryClasspathRootPath));
        
        return classpathRoot.getAbsolutePath();
    }
}