package core.annotations.registry;

import core.annotations.registry.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.annotations.registry.tasks.SetAnnotationsAsRegisteredForLibraryTask;

public class AnnotationsRegistrationServiceImpl implements AnnotationsRegistrationService
{
    private HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask;
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask;
    
    
    public AnnotationsRegistrationServiceImpl()
    {
        initialiseDependencies();
    }
    
    
    private void initialiseDependencies()
    {
        this.haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
        this.setAnnotationsAsRegisteredForLibraryTask = new SetAnnotationsAsRegisteredForLibraryTask();
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return haveAnnotationsBeenRegisteredForLibraryTask.run(libraryName);
    }

    
    @Override
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName)
    {
        return !haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        setAnnotationsAsRegisteredForLibraryTask.run(libraryName);
    }
}