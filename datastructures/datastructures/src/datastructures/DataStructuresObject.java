package datastructures;

import core.configuration.DefaultConfigurationEnumeration;
import core.configuration.LibraryConfiguration;
import core.objects.OrionObject;
import datastructures.configuration.DataStructuresConfigurationEnumeration;

public abstract class DataStructuresObject extends OrionObject
{
    public DataStructuresObject()
    {
        /*LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName(DataStructuresConfigurationEnumeration.LIBRARY_NAME.get());
        StringBuffer sb = new StringBuffer();
        sb.append("/");
        sb.append(libraryConfiguration.getLibraryName());
        libraryConfiguration.setLibraryClassPath(sb.toString());
        libraryConfiguration.setConfigurationFileName("DataStructures.prop");
        sb = new StringBuffer();
        sb.append(libraryConfiguration.getLibraryClassPath());
        sb.append("/");
        sb.append(DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get());
        sb.append("/");
        sb.append(libraryConfiguration.getConfigurationFileName());
        libraryConfiguration.setConfigurationFilePath(sb.toString());
        libraryConfiguration.setAnnotationsDefinitionFileName("DataStructuresAnnotations.prop");
        sb = new StringBuffer();
        sb.append(libraryConfiguration.getLibraryClassPath());
        sb.append("/");
        sb.append(DefaultConfigurationEnumeration.DEFAULT_CONFIGURATION_DIR.get());
        sb.append("/");
        sb.append(libraryConfiguration.getAnnotationsDefinitionFileName());
        libraryConfiguration.setAnnotationsDefinitionFilePath(sb.toString());
        sb = new StringBuffer();
        sb.append(libraryConfiguration.getLibraryName());
        sb.append(DefaultConfigurationEnumeration.DEFAULT_INTEGRATION_TESTS_DIR.get());
        libraryConfiguration.setIntegrationTestsClassPath(sb.toString());
        sb = new StringBuffer();
        sb.append(libraryConfiguration.getLibraryName());
        sb.append(DefaultConfigurationEnumeration.DEFAULT_UNIT_TESTS_DIR.get());
        libraryConfiguration.setUnitTestsClassPath(sb.toString());*/  
        registerLibraryConfiguration(DataStructuresConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}