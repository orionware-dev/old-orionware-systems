package core.objects.orionobject;

import configuration.LibraryConfiguration;
import core.services.OrionService;

public interface OrionObjectProcessorService extends OrionService
{
    public void registerLibraryConfiguration(String libraryConfigurationEnumerationClassPath);
    
    
    public LibraryConfiguration convertConfigurationEnumerationToLibraryConfiguration(String libraryConfigurationEnumerationClassPath);


    public void processAllLibrariesConfiguration(Object object);
}