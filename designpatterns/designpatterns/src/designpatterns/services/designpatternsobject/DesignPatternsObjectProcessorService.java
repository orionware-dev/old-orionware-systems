package designpatterns.services.designpatternsobject;

import core.configuration.LibraryConfiguration;
import core.services.OrionService;

public interface DesignPatternsObjectProcessorService extends OrionService
{
    public LibraryConfiguration convertConfigurationEnumerationToLibraryConfiguration(String libraryConfigurationEnumerationClassPath);
    
    
    public void processAllLibrariesConfiguration(Object object);
}