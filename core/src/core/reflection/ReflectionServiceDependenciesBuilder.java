package core.reflection;

import core.general.ObjectDependenciesBuilder;
import core.reflection.tasks.CallConstructorTask;
import core.reflection.tasks.CallMethodTask;
import core.reflection.tasks.GetConstructorsArrayTask;
import core.reflection.tasks.GetMethodsArrayTask;
import core.reflection.tasks.InstantiateClassTask;
import core.reflection.tasks.LoadClassTask;
import core.reflection.tasks.MakeMethodAccessibleTask;

public class ReflectionServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(ReflectionServiceImpl object)
    {
        object.setGetMethodsArrayTask(new GetMethodsArrayTask());
        object.setGetConstructorsArrayTask(new GetConstructorsArrayTask());
        object.setMakeMethodAccessibleTask(new MakeMethodAccessibleTask());
        object.setCallMethodTask(new CallMethodTask());
        object.setCallConstructorTask(new CallConstructorTask());
        object.setLoadClassTask(new LoadClassTask());
        object.setInstantiateClassTask(new InstantiateClassTask());
    }
}