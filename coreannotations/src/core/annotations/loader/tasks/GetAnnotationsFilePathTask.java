package core.annotations.loader.tasks;

import core.annotations.OrionAnnotationTask;

public class GetAnnotationsFilePathTask implements OrionAnnotationTask
{
    public String run(String classpathRoot, String libraryAnnotationsFilePath)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsFilePath);
        return sb.toString();
    }
}