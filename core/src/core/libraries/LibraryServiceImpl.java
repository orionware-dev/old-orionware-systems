package core.libraries;

import core.libraries.tasks.IsCoreLibraryTask;

public class LibraryServiceImpl implements LibraryService
{
    private IsCoreLibraryTask isCoreLibraryTask;
    
    
    public LibraryServiceImpl()
    {
        new LibraryServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
    //this method is accurate when it is called from a base object
    //like inside OrionObject.java or DataStructureObject.java
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return isCoreLibraryTask.run(classBeingRun);
    }


    public void setIsCoreLibraryTask(IsCoreLibraryTask isCoreLibraryTask)
    {
        this.isCoreLibraryTask = isCoreLibraryTask;
    }
}