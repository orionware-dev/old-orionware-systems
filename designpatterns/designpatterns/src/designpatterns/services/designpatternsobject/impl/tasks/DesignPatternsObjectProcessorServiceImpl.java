package designpatterns.services.designpatternsobject.impl.tasks;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import core.OrionSimpleObject;
import core.configuration.ConfigurationEnumeration;
import core.configuration.LibrariesConfiguration;
import core.configuration.LibraryConfiguration;
import core.objects.services.orionobject.OrionObjectProcessorService;
import core.objects.services.orionobject.impl.tasks.BuildSetterMethodToCallInLibraryConfigurationTask;
import core.objects.services.orionobject.impl.tasks.InitialiseCoreConfigurationTask;
import core.objects.services.orionobject.impl.tasks.IsCoreLibraryTask;
import core.objects.services.orionobject.impl.tasks.SetEnumerationValueToLibraryConfigurationTask;
import designpatterns.services.designpatternsobject.DesignPatternsObjectProcessorService;

public class DesignPatternsObjectProcessorServiceImpl extends OrionSimpleObject implements DesignPatternsObjectProcessorService
{
    public DesignPatternsObjectProcessorServiceImpl(Object object)
    {
        LibraryConfiguration coreLibraryConfiguration = new InitialiseCoreConfigurationTask().run();
        LibrariesConfiguration.registerLibraryConfiguration(coreLibraryConfiguration);
        
        if(new IsCoreLibraryTask().run(getClass()))
        {
            loadLibrariesProperties();
            registerLibrariesAnnotations();
        }
    }
    
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public LibraryConfiguration convertConfigurationEnumerationToLibraryConfiguration(String libraryConfigurationEnumerationClassPath)
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        
        try
        {
            Class<ConfigurationEnumeration> temp = (Class<ConfigurationEnumeration>)Class.forName(libraryConfigurationEnumerationClassPath);
            Class<Enum> temp1 = (Class<Enum>)Class.forName(libraryConfigurationEnumerationClassPath);
            Enum[] enums = null;
            
            try
            {
                enums = (Enum[])temp.getMethod("values", new Class<?>[]{})
                           .invoke(temp, new Object[]{});
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
            
            Arrays.stream(enums)
                .forEach(enumerationDefinition -> getLibraryEnumerationValueAndSetItToLibraryConfiguration(temp, temp1, enumerationDefinition, libraryConfiguration));
        }
        catch(ClassNotFoundException exception1)
        {
            exception1.printStackTrace();
        }
        
        return libraryConfiguration;
    }
    
    
    @SuppressWarnings("rawtypes")
    private void getLibraryEnumerationValueAndSetItToLibraryConfiguration(Class<ConfigurationEnumeration> libraryConfigurationEnumerationClass, Class<Enum> libraryConfigurationAbstractEnumerationClass, Enum enumerationDefinition, LibraryConfiguration libraryConfiguration)
    {
        String enumerationName = enumerationDefinition.name();
        String setterMethodToCallInLibraryConfiguration = new BuildSetterMethodToCallInLibraryConfigurationTask().run(enumerationName);
        String enumerationValue = getEnumerationValueForLibrary(libraryConfigurationEnumerationClass, libraryConfigurationAbstractEnumerationClass, enumerationName);
        new SetEnumerationValueToLibraryConfigurationTask().run(libraryConfiguration, setterMethodToCallInLibraryConfiguration, enumerationValue);
    }
    
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    private String getEnumerationValueForLibrary(Class<ConfigurationEnumeration> libraryConfigurationEnumerationClass, Class<Enum> libraryConfigurationAbstractEnumerationClass, String enumerationName)
    {
        try
        {
            return (String)libraryConfigurationEnumerationClass.getMethod("get", new Class<?>[]{})
                       .invoke(Enum.valueOf((Class<Enum>)libraryConfigurationAbstractEnumerationClass, enumerationName), new Object[]{});
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
        
        return null;
    }
    
    
    @Override
    public void processAllLibrariesConfiguration(Object object)
    {
        loadLibrariesProperties();
        registerLibrariesAnnotations();
    }
    
    
    private void loadLibrariesProperties()
    {
        new ConfigurationClasspathFacadeImpl().loadLibrariesProperties();
    }
    
    
    private void registerLibrariesAnnotations()
    {
        new AnnotationsRegistrationFacadeImpl().registerLibrariesAnnotations();
    }
}