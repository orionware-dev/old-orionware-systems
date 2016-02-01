package coreintegrationtests.servicedependencyinjection;

import core.OrionObject;
import core.services.OrionService;

public interface TestService extends OrionService
{
    public String testThisClassIsRunning();
}