package core.annotations.registry;

import core.annotations.registry.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.annotations.registry.tasks.SetAnnotationsAsRegisteredForLibraryTask;

public class AnnotationsRegistrationServiceImpl implements AnnotationsRegistrationService
{
    private HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask;
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask;
    
    
    public AnnotationsRegistrationServiceImpl()
    {
        new AnnotationsRegistrationServiceDependenciesBuilder().injectDependencies(this);
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


    public void setHaveAnnotationsBeenRegisteredForLibraryTask(HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask)
    {
        this.haveAnnotationsBeenRegisteredForLibraryTask = haveAnnotationsBeenRegisteredForLibraryTask;
    }


    public void setSetAnnotationsAsRegisteredForLibraryTask(SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask)
    {
        this.setAnnotationsAsRegisteredForLibraryTask = setAnnotationsAsRegisteredForLibraryTask;
    }
}