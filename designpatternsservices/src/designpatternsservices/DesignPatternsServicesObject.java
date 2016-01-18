package designpatternsservices;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DesignPatternsServicesObject extends OrionObject
{
    public DesignPatternsServicesObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("designpatternsservices");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}