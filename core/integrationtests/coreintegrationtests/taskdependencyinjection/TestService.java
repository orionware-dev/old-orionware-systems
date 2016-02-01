package coreintegrationtests.taskdependencyinjection;

import core.services.OrionService;

public interface TestService extends OrionService
{
    public String testThisClassIsRunning();
}