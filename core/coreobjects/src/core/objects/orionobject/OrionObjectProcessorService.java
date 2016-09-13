package core.objects.orionobject;

import core.services.OrionService;

public interface OrionObjectProcessorService extends OrionService
{
    public void registerLibraryConfiguration(String libraryConfigurationEnumerationClassPath);


    public void processAllLibrariesConfiguration(Object object);
}