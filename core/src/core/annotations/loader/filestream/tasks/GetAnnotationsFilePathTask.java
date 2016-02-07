package core.annotations.loader.filestream.tasks;

import core.services.OrionTask;

public class GetAnnotationsFilePathTask implements OrionTask
{
    public String run(String classpathRoot, String libraryAnnotationsFilePath)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsFilePath);
        return sb.toString();
    }
}