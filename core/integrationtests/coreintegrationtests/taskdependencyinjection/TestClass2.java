package coreintegrationtests.taskdependencyinjection;

import core.OrionObject;
import core.taskdependencyinjection.TaskInjector;
import coreintegrationtests.taskdependencyinjection.impl.tasks.TestTask;

public class TestClass2 extends OrionObject
{
    private TestTask testTask;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.taskdependencyinjection.TestClass2...";
    }
    
    
    public String testTestTaskIsRunning()
    {
        return testTask.testThisClassIsRunning();
    }
    
    
    @TaskInjector(ID = "coreintegrationtests.taskdependencyinjection.TestTask")
    private void setTestTask(TestTask testTask)
    {
        this.testTask = testTask;
    }
}