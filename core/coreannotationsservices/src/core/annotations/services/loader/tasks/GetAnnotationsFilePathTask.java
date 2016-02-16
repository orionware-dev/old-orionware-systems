package core.annotations.services.loader.tasks;

import core.annotations.AnnotationObject;
import core.annotations.AnnotationTask;

public class GetAnnotationsFilePathTask extends AnnotationObject implements AnnotationTask
{
    public String run(String classpathRoot, String libraryAnnotationsFilePath)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsFilePath);
        return sb.toString();
    }
}