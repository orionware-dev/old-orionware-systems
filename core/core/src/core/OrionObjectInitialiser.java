package core;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class OrionObjectInitialiser extends OrionSimpleObject
{
    private static final String LIBRARY_CONFIGURATION_CLASS_PATH = "core.configuration.LibraryConfiguration";
    private static final String CORE_CONFIGURATION_ENUM_PATH = "core.configuration.CoreConfigurationEnum";
    
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object getInitialisedCoreConfiguration()
    {
        Object libraryConfiguration = instantiateClass(LIBRARY_CONFIGURATION_CLASS_PATH);
        
        try
        {
            Class<Enum> coreConfigurationEnumClass = (Class<Enum>)Class.forName(CORE_CONFIGURATION_ENUM_PATH);
            Enum[] enumDefinitionsArray = coreConfigurationEnumClass.getEnumConstants();
            Arrays.stream(enumDefinitionsArray)
                .forEach((enumDefinition) -> getEnumValueAndSetItToLibraryConfiguration(coreConfigurationEnumClass, enumDefinition, libraryConfiguration));
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        
        return libraryConfiguration;
    }
    
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    private void getEnumValueAndSetItToLibraryConfiguration(Class<Enum> coreConfigurationEnumClass, Enum enumDefinition, Object libraryConfiguration)
    {
        String enumName = enumDefinition.name();
        String setterMethodToCallInLibraryConfiguration = "set";
        String[] enumNameTokens = enumName.split("_");
        
        for(String enumNameToken : enumNameTokens)
        {
            enumNameToken = enumNameToken.toLowerCase();
            char[] enumNameTokenCharactersArray = enumNameToken.toCharArray();
            enumNameTokenCharactersArray[0] = Character.toUpperCase(enumNameTokenCharactersArray[0]);
            setterMethodToCallInLibraryConfiguration += String.copyValueOf(enumNameTokenCharactersArray);
        }
        
        Enum coreLibraryNameEnum = Enum.valueOf(coreConfigurationEnumClass, enumName);
        String enumValue = null;
        
        try
        {
            enumValue = (String)coreConfigurationEnumClass.getMethod("get", new Class<?>[]{}).invoke(coreLibraryNameEnum, new Object[]{});
            libraryConfiguration.getClass().getMethod(setterMethodToCallInLibraryConfiguration, String.class).invoke(libraryConfiguration, enumValue);
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