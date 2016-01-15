package designpatternsfacades;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DesignPatternFacadeObject extends OrionObject
{
    public DesignPatternFacadeObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("designpatternsfacades");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}