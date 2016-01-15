package designpatternsservices;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DesignPatternServiceObject extends OrionObject
{
    public DesignPatternServiceObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("designpatternsservices");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}