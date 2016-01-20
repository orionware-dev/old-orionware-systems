package core.annotations.configuration.tasks;

import java.io.InputStream;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.LibraryConfiguration;
import core.general.OrionProperties;
import core.services.OrionTask;

public class LibraryAnnotationsRegistrationCheckTask implements OrionTask
{
    public OrionProperties run(AnnotationsConfigurationService annotationsConfigurationService, LibraryConfiguration libraryConfiguration)
    {
        OrionProperties annotationsDeclarations = new OrionProperties();
        InputStream libraryAnnotationsFileStream = annotationsConfigurationService.getAnnotationsFileStream(libraryConfiguration.getLibraryName(), libraryConfiguration.getAnnotationsFilePath());
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        annotationsConfigurationService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
}