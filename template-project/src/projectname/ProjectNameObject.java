package projectname;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class ProjectNameObject extends OrionObject
{
    public ProjectNameObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("<project_name>");
        libraryConfiguration.setConfigurationFilePath("/configuration/<project_name>.prop");
        libraryConfiguration.setAnnotationsFilePath("/configuration/<project_name>Annotations.prop");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}