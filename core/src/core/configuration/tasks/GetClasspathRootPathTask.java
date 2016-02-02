package core.configuration.tasks;

import java.io.File;
import core.configuration.CoreConfigurationEnum;
import core.general.DefaultConfigurationEnum;
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
            sb.append(CoreConfigurationEnum.CLASSPATH_ROOT.get());
            
            if(libraryClasspathRootPathDoesNotEqualCoreClasspathRoot(libraryClasspathRootPath)
                && classpathRootEndsWithCoreClasspathRoot(classpathRoot, sb))
            {
                classpathRoot = new File(classpathRoot.getParent());
                sb = new StringBuilder();
                sb.append(CoreConfigurationEnum.CLASSPATH_ROOT.get());
                sb.append(File.separator);
                sb.append(DefaultConfigurationEnum.BIN_DIR.get());
                
                if(classpathRootEndsWithCoreClasspathBinDir(classpathRoot, sb))
                {
                    classpathRoot = new File(classpathRoot.getParent());
                    classpathRoot = new File(classpathRoot.getParent());
                    sb = new StringBuilder();
                    sb.append(classpathRoot.getAbsolutePath());
                    sb.append(File.separator);
                    sb.append(libraryClasspathRootPath);
                    sb.append(File.separator);
                    sb.append(DefaultConfigurationEnum.BIN_DIR.get());
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
    
    
    private boolean libraryClasspathRootPathDoesNotEqualCoreClasspathRoot(String libraryClasspathRootPath)
    {
        return !CoreConfigurationEnum.CLASSPATH_ROOT.get().equals(libraryClasspathRootPath);
    }
    
    
    private boolean classpathRootEndsWithCoreClasspathRoot(File classpathRoot, StringBuilder sb)
    {
        return classpathRoot.getAbsolutePath().endsWith(sb.toString());
    }
    
    
    private boolean classpathRootEndsWithCoreClasspathBinDir(File classpathRoot, StringBuilder sb)
    {
        return classpathRoot.getAbsolutePath().endsWith(sb.toString());
    }
}