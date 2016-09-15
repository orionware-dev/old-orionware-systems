package annotations.registry.impl.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibraryConfiguration;

public class FilterLibrariesConfigurationsHavingAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<LibraryConfiguration> run(Collection<LibraryConfiguration> librariesConfiguration)
    {
        List<LibraryConfiguration> notNullLibrariesConfigurations = new ArrayList<LibraryConfiguration>();
        
        for(LibraryConfiguration libraryConfiguration : librariesConfiguration)
        {
            if(libraryConfiguration.getAnnotationsDefinitionFilePath() != null)
            {
                notNullLibrariesConfigurations.add(libraryConfiguration);
            }
        }
        
        return notNullLibrariesConfigurations;
    }
}