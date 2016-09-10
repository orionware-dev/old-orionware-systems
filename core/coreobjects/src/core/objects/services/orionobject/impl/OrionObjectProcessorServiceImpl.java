package core.objects.services.orionobject.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import annotations.services.processor.impl.AnnotationsProcessorServiceImpl;
import annotations.services.registry.impl.AnnotationsRegistrationServiceImpl;
import configuration.LibrariesConfiguration;
import configuration.LibrariesConfigurationMapper;
import configuration.LibraryConfiguration;
import configuration.services.classpath.impl.ConfigurationClasspathServiceImpl;
import core.OrionSimpleObject;
import core.abstraction.ConfigurationEnumeration;
import core.objects.services.orionobject.OrionObjectProcessorService;
import core.objects.services.orionobject.impl.tasks.BuildSetterMethodToCallInLibraryConfigurationTask;
import core.objects.services.orionobject.impl.tasks.InitialiseCoreConfigurationTask;
import core.objects.services.orionobject.impl.tasks.IsCoreLibraryTask;
import core.objects.services.orionobject.impl.tasks.SetEnumerationValueToLibraryConfigurationTask;

public class OrionObjectProcessorServiceImpl extends OrionSimpleObject implements OrionObjectProcessorService
{
    public OrionObjectProcessorServiceImpl(Object object)
    {
        if(LibrariesConfigurationMapper.coreLibrariesHaveNotBeenRegistered)
        {
            InitialiseCoreConfigurationTask initialiseCoreConfigurationTask = new InitialiseCoreConfigurationTask();
            LibraryConfiguration coreLibraryConfiguration = initialiseCoreConfigurationTask.runCore();
            LibrariesConfiguration.registerLibraryConfiguration(coreLibraryConfiguration);
            LibraryConfiguration coreDependencyInjectionLibraryConfiguration = initialiseCoreConfigurationTask.runDependencyInjection();
            LibrariesConfiguration.registerLibraryConfiguration(coreDependencyInjectionLibraryConfiguration);

            if(new IsCoreLibraryTask().run(getClass()))
            {
                processAllLibrariesConfiguration(object);
            }
        }
    }
    
    
    @Override
    public void registerLibraryConfiguration(String libraryConfigurationEnumerationClassPath)
    {
        if(!LibrariesConfiguration.getLibrariesConfigurationEnumerationClassPaths().contains(libraryConfigurationEnumerationClassPath))
        {
            LibraryConfiguration libraryConfiguration = convertConfigurationEnumerationToLibraryConfiguration(libraryConfigurationEnumerationClassPath);
            LibrariesConfiguration.registerLibraryConfiguration(libraryConfiguration);
            LibrariesConfiguration.registerLibraryConfigurationEnumerationClassPath(libraryConfigurationEnumerationClassPath);
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
                enums = (Enum[])temp.getMethod("values", new Class<?>[]{}).invoke(temp, new Object[]{});
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

            Arrays.stream(enums).forEach(enumerationDefinition -> getLibraryEnumerationValueAndSetItToLibraryConfiguration(temp, temp1, enumerationDefinition, libraryConfiguration));
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
            return (String)libraryConfigurationEnumerationClass.getMethod("get", new Class<?>[]{}).invoke(Enum.valueOf((Class<Enum>)libraryConfigurationAbstractEnumerationClass, enumerationName), new Object[]{});
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
        processAllAnnotations(object);
    }


    private void loadLibrariesProperties()
    {
        new ConfigurationClasspathServiceImpl().loadLibrariesProperties();
    }


    private void registerLibrariesAnnotations()
    {
        new AnnotationsRegistrationServiceImpl().registerLibrariesAnnotations();
    }


    private void processAllAnnotations(Object object)
    {
        new AnnotationsProcessorServiceImpl().processAllAnnotations(object);
    }
}