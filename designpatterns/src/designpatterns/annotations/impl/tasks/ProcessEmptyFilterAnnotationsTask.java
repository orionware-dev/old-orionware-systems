package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import reflection.instancevariables.retrieval.impl.ReflectionInstanceVariablesRetrievalServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyFilterAnnotationsTask extends DesignPatternsObject implements DesignPatternsTask
{
    public void run(Object object)
    {
        ProcessInstanceVariableForEmptyFilterInjectionTask processInstanceVariableForEmptyFilterInjectionTask = new ProcessInstanceVariableForEmptyFilterInjectionTask();
        ProcessMethodForEmptyFilterInjectionTask processMethodForEmptyFilterInjectionTask = new ProcessMethodForEmptyFilterInjectionTask();
        
        List<Field> fields = new ReflectionInstanceVariablesRetrievalServiceImpl().getDeclaredInstanceVariables(object);
        fields.forEach(field -> processInstanceVariableForEmptyFilterInjectionTask.run(object, field));
        List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
        methods.forEach(method -> processMethodForEmptyFilterInjectionTask.run(object, method));
    }
}