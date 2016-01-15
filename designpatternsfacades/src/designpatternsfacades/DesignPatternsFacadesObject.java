package designpatternsfacades;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DesignPatternsFacadesObject extends OrionObject
{
    public DesignPatternsFacadesObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("designpatternsfacades");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}