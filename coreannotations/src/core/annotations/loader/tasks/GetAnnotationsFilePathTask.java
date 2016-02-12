package core.annotations.loader.tasks;

import core.annotations.AnnotationTask;

public class GetAnnotationsFilePathTask implements AnnotationTask
{
    public String run(String classpathRoot, String libraryAnnotationsFilePath)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsFilePath);
        return sb.toString();
    }
}