package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import reflection.instancevariables.retrieval.impl.ReflectionInstanceVariablesRetrievalServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyPipelineAnnotationsTask extends DesignPatternsObject implements DesignPatternsTask
{
    public void run(Object object)
    {
        ProcessMethodForEmptyPipelineInjectionTask processMethodForEmptyPipelineInjectionTask = new ProcessMethodForEmptyPipelineInjectionTask();
        ProcessInstanceVariableForEmptyPipelineInjectionTask processInstanceVariableForEmptyPipelineInjectionTask = new ProcessInstanceVariableForEmptyPipelineInjectionTask();
        
        List<Field> fields = new ReflectionInstanceVariablesRetrievalServiceImpl().getDeclaredInstanceVariables(object);
        fields.forEach(field -> processInstanceVariableForEmptyPipelineInjectionTask.run(object, field));
        List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
        methods.forEach(method -> processMethodForEmptyPipelineInjectionTask.run(object, method));
    }
}