package core.objects.services.orionobject;

import configuration.LibraryConfiguration;
import core.services.OrionService;

public interface OrionObjectProcessorService extends OrionService
{
    public LibraryConfiguration convertConfigurationEnumerationToLibraryConfiguration(String libraryConfigurationEnumerationClassPath);


    public void processAllLibrariesConfiguration(Object object);
}