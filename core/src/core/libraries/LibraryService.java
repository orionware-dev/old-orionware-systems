package core.libraries;

import core.services.OrionService;

public interface LibraryService extends OrionService
{
    public boolean isCoreLibrary(Class<?> classBeingRun);
}