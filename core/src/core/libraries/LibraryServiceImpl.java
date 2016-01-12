package core.libraries;

import core.libraries.tasks.IsCoreLibraryTask;

public class LibraryServiceImpl implements LibraryService
{
    //this method is accurate when it is called from a base object
    //like inside OrionObject.java or DataStructureObject.java
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return (boolean)new IsCoreLibraryTask().execute(classBeingRun);
    }
}