package core.annotations.services.loader.tasks;

import core.OrionSimpleObject;
import core.annotations.AnnotationTask;

public class GetAnnotationsFilePathTask extends OrionSimpleObject implements AnnotationTask
{
    public String run(String classpathRoot, String libraryAnnotationsFilePath)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsFilePath);
        return sb.toString();
    }
}