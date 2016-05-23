package core;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class OrionObjectInitialiser extends OrionSimpleObject
{
    public Object getLibraryConfigurationInstance()
    {
        return instantiateClass("core.configuration.LibraryConfiguration");
    }
    
    
    public Object getConfigurationServiceInstance()
    {
        return instantiateClass("core.configuration.classpath.ConfigurationServiceImpl");
    }
    
    
    public Object getAnnotationsRegistrationServiceInstance()
    {
        return instantiateClass("core.annotations.services.registry.AnnotationsRegistrationServiceImpl");
    }
    
    
    public Object getAnnotationsProcessorServiceInstance()
    {
        return instantiateClass("core.annotations.services.processor.AnnotationsProcessorServiceImpl");
    }
    
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object getInitialisedCoreConfiguration(Object libraryConfiguration)
    {
        try
        {
            Class<Enum> coreConfigurationEnumClass = (Class<Enum>)Class.forName("core.configuration.CoreConfigurationEnum");
            Enum coreLibraryNameEnum = Enum.valueOf(coreConfigurationEnumClass, "LIBRARY_NAME");
            String coreLibraryNameValue = (String)coreConfigurationEnumClass.getMethod("get", new Class<?>[]{}).invoke(coreLibraryNameEnum, new Object[]{});
            Enum coreLibraryClassPathEnum = Enum.valueOf(coreConfigurationEnumClass, "LIBRARY_CLASS_PATH");
            String coreLibraryClassPathValue = (String)coreConfigurationEnumClass.getMethod("get", new Class<?>[]{}).invoke(coreLibraryClassPathEnum, new Object[]{});
            Enum corePropertiesFilePathEnum = Enum.valueOf(coreConfigurationEnumClass, "PROPERTIES_FILE_PATH");
            String corePropertiesFilePathValue = (String)coreConfigurationEnumClass.getMethod("get", new Class<?>[]{}).invoke(corePropertiesFilePathEnum, new Object[]{});
            Enum coreAnnotationsDefinitionFilePathEnum = Enum.valueOf(coreConfigurationEnumClass, "ANNOTATIONS_DEFINITION_FILE_PATH");
            String coreAnnotationsDefinitionFilePathValue = (String)coreConfigurationEnumClass.getMethod("get", new Class<?>[]{}).invoke(coreAnnotationsDefinitionFilePathEnum, new Object[]{});
            libraryConfiguration.getClass().getMethod("setLibraryName", String.class).invoke(libraryConfiguration, coreLibraryNameValue);
            libraryConfiguration.getClass().getMethod("setLibraryClassPath", String.class).invoke(libraryConfiguration, coreLibraryClassPathValue);
            libraryConfiguration.getClass().getMethod("setConfigurationFilePath", String.class).invoke(libraryConfiguration, corePropertiesFilePathValue);
            libraryConfiguration.getClass().getMethod("setAnnotationsFilePath", String.class).invoke(libraryConfiguration, coreAnnotationsDefinitionFilePathValue);
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        
        return libraryConfiguration;
    }
    
    
    private Object instantiateClass(String className)
    {
        try
        {
            Class<?> classToInstantiate = ClassLoader.getSystemClassLoader().loadClass(className);
            return classToInstantiate.getConstructor().newInstance();
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
    
    
    public boolean thisIsCoreLibrary(Object configurationService, Class<?> aClass)
    {
        try
        {
            return (boolean)configurationService.getClass().getMethod("isCoreLibrary", Class.class).invoke(configurationService, aClass);
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        
        return false;
    }
    
    
    public void processAllLibrariesConfiguration(Object configurationService, Set<Object> librariesConfigurationSet)
    {
        try
        {
            configurationService.getClass().getMethod("loadLibrariesProperties", Set.class).invoke(configurationService, librariesConfigurationSet);
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    public void registerLibrariesAnnotations(Object annotationsRegistrationService, Set<Object> librariesConfigurationSet)
    {
        try
        {
            annotationsRegistrationService.getClass().getMethod("registerLibrariesAnnotations", Set.class).invoke(annotationsRegistrationService, librariesConfigurationSet);
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    public void processAllAnnotations(Object annotationsProcessorService, Object object)
    {
        try
        {
            annotationsProcessorService.getClass().getMethod("processAllAnnotations", Object.class).invoke(annotationsProcessorService, object);
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
    }
}