package core;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class OrionObjectInitialiser extends OrionSimpleObject
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object getInitialisedCoreConfiguration()
    {
        Object libraryConfiguration = instantiateClass("core.configuration.LibraryConfiguration");
        
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
            libraryConfiguration.getClass().getMethod("setAnnotationsDefinitionFilePath", String.class).invoke(libraryConfiguration, coreAnnotationsDefinitionFilePathValue);
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
    
    
    public boolean thisIsCoreLibrary(Class<?> aClass)
    {
        try
        {
            Object configurationFacade = instantiateClass("core.configuration.facades.classpath.impl.ConfigurationClasspathFacadeImpl");
            return (boolean)configurationFacade.getClass().getMethod("isCoreLibrary", Class.class).invoke(configurationFacade, aClass);
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
    
    
    public void loadLibrariesProperties(Set<Object> librariesConfigurationSet)
    {
        try
        {
            Object configurationFacade = instantiateClass("core.configuration.facades.classpath.impl.ConfigurationClasspathFacadeImpl");
            configurationFacade.getClass().getMethod("loadLibrariesProperties", Set.class).invoke(configurationFacade, librariesConfigurationSet);
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
    
    
    public void registerLibrariesAnnotations(Set<Object> librariesConfigurationSet)
    {
        try
        {
            Object annotationsRegistrationFacade = instantiateClass("core.annotations.facades.registration.impl.AnnotationsRegistrationFacadeImpl");
            annotationsRegistrationFacade.getClass().getMethod("registerLibrariesAnnotations", Set.class).invoke(annotationsRegistrationFacade, librariesConfigurationSet);
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
    
    
    public void processAllAnnotations(Object object)
    {
        try
        {
            Object annotationsProcessorFacade = instantiateClass("core.annotations.facades.processor.impl.AnnotationsProcessorFacadeImpl");
            annotationsProcessorFacade.getClass().getMethod("processAllAnnotations", Object.class).invoke(annotationsProcessorFacade, object);
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