package annotations.registry.impl.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibraryConfiguration;

public class FilterNotRegisteredLibrariesConfigurationTask extends AnnotationServiceObject implements AnnotationTask
{
    public static List<LibraryConfiguration> run(Collection<LibraryConfiguration> librariesConfiguration)
    {
        List<LibraryConfiguration> notRegisteredLibrariesConfigurationsHavingAnnotations = new ArrayList<LibraryConfiguration>();
        List<LibraryConfiguration> librariesConfigurationsHavingAnnotations = FilterLibrariesConfigurationsHavingAnnotationsTask.run(librariesConfiguration);
        
        for(LibraryConfiguration libraryConfiguration : librariesConfigurationsHavingAnnotations)
        {
            if(!HaveAnnotationsBeenRegisteredForLibraryTask.run(libraryConfiguration))
            {
                notRegisteredLibrariesConfigurationsHavingAnnotations.add(libraryConfiguration);
            }
        }

        return notRegisteredLibrariesConfigurationsHavingAnnotations;
    }
}