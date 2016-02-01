package coreintegrationtests.servicedependencyinjection.impl;

import core.OrionObject;
import core.services.OrionService;
import coreintegrationtests.servicedependencyinjection.TestService;

public class TestServiceImpl extends OrionObject implements TestService
{
    @Override
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.servicedependencyinjection.impl.TestServiceImpl...";
    }
}