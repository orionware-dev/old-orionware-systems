package core.objects.services.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import core.OrionSimpleObject;
import core.annotations.facades.processor.impl.AnnotationsProcessorFacadeImpl;
import core.annotations.facades.registration.impl.AnnotationsRegistrationFacadeImpl;
import core.configuration.CoreConfigurationEnumeration;
import core.configuration.LibrariesConfiguration;
import core.configuration.LibraryConfiguration;
import core.configuration.facades.classpath.impl.ConfigurationClasspathFacadeImpl;
import core.objects.services.OrionObjectProcessorService;
import core.objects.services.impl.tasks.IsCoreLibraryTask;

public class OrionObjectProcessorServiceImpl extends OrionSimpleObject implements OrionObjectProcessorService
{
    public OrionObjectProcessorServiceImpl(Object object)
    {
        LibraryConfiguration coreLibraryConfiguration = getInitialisedCoreConfiguration();
        LibrariesConfiguration.registerLibraryConfiguration(coreLibraryConfiguration);
        
        if(new IsCoreLibraryTask().run(getClass()))
        {
            loadLibrariesProperties();
            registerLibrariesAnnotations();
            processAllAnnotations(object);
        }
    }
    
    
    private LibraryConfiguration getInitialisedCoreConfiguration()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        Arrays.stream(CoreConfigurationEnumeration.values())
            .forEach(enumerationDefinition -> getEnumerationValueAndSetItToLibraryConfiguration(CoreConfigurationEnumeration.class, enumerationDefinition, libraryConfiguration));
        return libraryConfiguration;
    }
    
    
    @SuppressWarnings({"rawtypes"})
    private void getEnumerationValueAndSetItToLibraryConfiguration(Class<CoreConfigurationEnumeration> coreConfigurationEnumerationClass, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = "set";
        String[] enumNameTokens = enumName.split("_");
        
        for(String enumNameToken : enumNameTokens)
        {
            setterMethodToCallInLibraryConfiguration = createSetterMethodToCallInLibraryConfiguration(enumNameToken, setterMethodToCallInLibraryConfiguration);
        }
        
        String enumValue = null;
        
        try
        {
            enumValue = (String)coreConfigurationEnumerationClass.getMethod("get", new Class<?>[]{})
                            .invoke(Enum.valueOf(coreConfigurationEnumerationClass, enumName), new Object[]{});
            libraryConfiguration.getClass()
                .getMethod(setterMethodToCallInLibraryConfiguration, String.class)
                .invoke(libraryConfiguration, enumValue);
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
    
    
    private String createSetterMethodToCallInLibraryConfiguration(String enumerationNameToken, String setterMethodToCallInLibraryConfiguration)
    {
        enumerationNameToken = enumerationNameToken.toLowerCase();
        char[] enumNameTokenCharactersArray = enumerationNameToken.toCharArray();
        enumNameTokenCharactersArray[0] = Character.toUpperCase(enumNameTokenCharactersArray[0]);
        return setterMethodToCallInLibraryConfiguration + String.copyValueOf(enumNameTokenCharactersArray);
    }
    
    
    @Override
    public void processAllLibrariesConfiguration(Object object)
    {
        loadLibrariesProperties();
        registerLibrariesAnnotations();
        processAllAnnotations(object);
    }
    
    
    private void loadLibrariesProperties()
    {
        new ConfigurationClasspathFacadeImpl().loadLibrariesProperties();
    }
    
    
    private void registerLibrariesAnnotations()
    {
        new AnnotationsRegistrationFacadeImpl().registerLibrariesAnnotations();
    }
    
    
    private void processAllAnnotations(Object object)
    {
        new AnnotationsProcessorFacadeImpl().processAllAnnotations(object);
    }
}