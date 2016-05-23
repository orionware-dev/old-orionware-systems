package core.annotations.services.loader.tasks;

import core.annotations.AnnotationObject;
import core.annotations.AnnotationTask;

public class GetAnnotationsDefinitionFilePathTask extends AnnotationObject implements AnnotationTask
{
    public String run(String classpathRoot, String libraryAnnotationsDefinitionFilePath)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(classpathRoot);
        sb.append(libraryAnnotationsDefinitionFilePath);
        return sb.toString();
    }
}