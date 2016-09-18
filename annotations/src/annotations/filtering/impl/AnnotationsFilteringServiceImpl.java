package annotations.filtering.impl;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.filtering.AnnotationsFilteringService;
import annotations.filtering.impl.tasks.libraries.FilterLibrariesConfigurationsHavingAnnotationsTask;
import annotations.filtering.impl.tasks.libraries.FilterNotRegisteredLibrariesConfigurationTask;
import annotations.filtering.impl.tasks.libraries.FilterRegisteredLibrariesConfigurationTask;
import annotations.filtering.impl.tasks.objects.DoesObjectHaveRegisteredAnnotationTask;
import annotations.filtering.impl.tasks.objects.FilterRegisteredAnnotationsFromObjectAnnotationsTask;
import configuration.LibraryConfiguration;

public class AnnotationsFilteringServiceImpl extends AnnotationServiceObject implements AnnotationsFilteringService
{
    @Override
    public List<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(Collection<OrionAnnotation> allObjectAnnotationsList)
    {
        return FilterRegisteredAnnotationsFromObjectAnnotationsTask.run(allObjectAnnotationsList);
    }


    @Override
    public boolean doesObjectHaveRegisteredAnnotation(Collection<OrionAnnotation> allObjectAnnotations, OrionAnnotation registeredAnnotation)
    {
        return DoesObjectHaveRegisteredAnnotationTask.run(allObjectAnnotations, registeredAnnotation);
    }
    
    
    @Override
    public List<LibraryConfiguration> filterLibrariesConfigurationsHavingAnnotations(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return FilterLibrariesConfigurationsHavingAnnotationsTask.run(librariesConfiguration);
    }
    
    
    @Override
    public List<LibraryConfiguration> filterRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return FilterRegisteredLibrariesConfigurationTask.run(librariesConfiguration);
    }


    @Override
    public List<LibraryConfiguration> filterNotRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return FilterNotRegisteredLibrariesConfigurationTask.run(librariesConfiguration);
    }
}