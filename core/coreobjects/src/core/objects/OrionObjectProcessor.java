package core.objects;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import core.OrionSimpleObject;
import core.annotations.facades.processor.AnnotationsProcessorFacade;
import core.annotations.facades.processor.impl.AnnotationsProcessorFacadeImpl;
import core.annotations.facades.registration.AnnotationsRegistrationFacade;
import core.annotations.facades.registration.impl.AnnotationsRegistrationFacadeImpl;
import core.configuration.CoreConfigurationEnumeration;
import core.configuration.LibrariesConfiguration;
import core.configuration.LibraryConfiguration;
import core.configuration.facades.classpath.ConfigurationClasspathFacade;
import core.configuration.facades.classpath.impl.ConfigurationClasspathFacadeImpl;

public class OrionObjectProcessor extends OrionSimpleObject
{
    public OrionObjectProcessor(Object object)
    {
        LibraryConfiguration coreLibraryConfiguration = getInitialisedCoreConfiguration();
        LibrariesConfiguration.registerLibraryConfiguration(coreLibraryConfiguration);
        
        if(thisIsCoreLibrary(getClass()))
        {
            loadLibrariesProperties();
            registerLibrariesAnnotations();
            processAllAnnotations(object);
        }
    }
    
    
    public LibraryConfiguration getInitialisedCoreConfiguration()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        
        try
        {
            Arrays.stream(CoreConfigurationEnumeration.values())
                .forEach(enumDefinition -> getEnumValueAndSetItToLibraryConfiguration(CoreConfigurationEnumeration.class, enumDefinition, libraryConfiguration));
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
    
    
    @SuppressWarnings({"rawtypes"})
    private void getEnumValueAndSetItToLibraryConfiguration(Class<CoreConfigurationEnumeration> coreConfigurationEnumClass, Enum enumDefinition, Object libraryConfiguration)
    {
        String enumName = enumDefinition.name();
        String setterMethodToCallInLibraryConfiguration = "set";
        String[] enumNameTokens = enumName.split("_");
        
        for(String enumNameToken : enumNameTokens)
        {
            setterMethodToCallInLibraryConfiguration = createSetterMethodToCallInLibraryConfiguration(enumNameToken, setterMethodToCallInLibraryConfiguration);
        }
        
        String enumValue = null;
        
        try
        {
            enumValue = (String)coreConfigurationEnumClass.getMethod("get", new Class<?>[]{})
                            .invoke(Enum.valueOf(coreConfigurationEnumClass, enumName), new Object[]{});
            libraryConfiguration.getClass()
                .getMethod(setterMethodToCallInLibraryConfiguration, String.class)
                .invoke(libraryConfiguration, enumValue);
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
    
    
    private String createSetterMethodToCallInLibraryConfiguration(String enumNameToken, String setterMethodToCallInLibraryConfiguration)
    {
        enumNameToken = enumNameToken.toLowerCase();
        char[] enumNameTokenCharactersArray = enumNameToken.toCharArray();
        enumNameTokenCharactersArray[0] = Character.toUpperCase(enumNameTokenCharactersArray[0]);
        return setterMethodToCallInLibraryConfiguration + String.copyValueOf(enumNameTokenCharactersArray);
    }
    
    
    public boolean thisIsCoreLibrary(Class<?> aClass)
    {
        try
        {
            return new IsCoreLibraryTask().run(aClass);
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        
        return false;
    }
    
    
    public void loadLibrariesProperties()
    {
        try
        {
            ConfigurationClasspathFacade configurationFacade = new ConfigurationClasspathFacadeImpl();
            configurationFacade.loadLibrariesProperties();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    public void registerLibrariesAnnotations()
    {
        try
        {
            AnnotationsRegistrationFacade annotationsRegistrationFacade = new AnnotationsRegistrationFacadeImpl();
            annotationsRegistrationFacade.registerLibrariesAnnotations();
        }
        catch(IllegalArgumentException exception)
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
            AnnotationsProcessorFacade annotationsProcessorFacade = new AnnotationsProcessorFacadeImpl();
            annotationsProcessorFacade.processAllAnnotations(object);
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
    }
}