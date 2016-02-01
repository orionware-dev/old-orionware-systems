package coreintegrationtests.taskdependencyinjection.impl;

import core.OrionObject;
import core.taskdependencyinjection.TaskInjector;
import coreintegrationtests.taskdependencyinjection.impl.tasks.TestTask;

public class TestServiceImpl extends OrionObject
{
    private TestTask testTask;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.taskdependencyinjection.impl.TestServiceImpl...";
    }
    
    
    public String testTestTaskIsRunning()
    {
        return testTask.testThisClassIsRunning();
    }
    
    
    @TaskInjector(ID = "TestTask")
    private void setTestTask(TestTask testTask)
    {
        this.testTask = testTask;
    }
}