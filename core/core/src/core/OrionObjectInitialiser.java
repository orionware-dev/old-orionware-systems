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
            String coreLibraryNameValue = getEnumValue(coreConfigurationEnumClass, "LIBRARY_NAME");
            libraryConfiguration.getClass().getMethod("setLibraryName", String.class).invoke(libraryConfiguration, coreLibraryNameValue);
            String coreLibraryClassPathValue = getEnumValue(coreConfigurationEnumClass, "LIBRARY_CLASS_PATH");
            libraryConfiguration.getClass().getMethod("setLibraryClassPath", String.class).invoke(libraryConfiguration, coreLibraryClassPathValue);
            String corePropertiesFilePathValue = getEnumValue(coreConfigurationEnumClass, "PROPERTIES_FILE_PATH");
            libraryConfiguration.getClass().getMethod("setConfigurationFilePath", String.class).invoke(libraryConfiguration, corePropertiesFilePathValue);
            String coreAnnotationsDefinitionFilePathValue = getEnumValue(coreConfigurationEnumClass, "ANNOTATIONS_DEFINITION_FILE_PATH");
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
    
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    private String getEnumValue(Class<Enum> coreConfigurationEnumClass, String enumName)
    {
        String enumValue = null;
        Enum coreLibraryNameEnum = Enum.valueOf(coreConfigurationEnumClass, enumName);
        
        try
        {
            enumValue = (String)coreConfigurationEnumClass.getMethod("get", new Class<?>[]{}).invoke(coreLibraryNameEnum, new Object[]{});
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        return enumValue;
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