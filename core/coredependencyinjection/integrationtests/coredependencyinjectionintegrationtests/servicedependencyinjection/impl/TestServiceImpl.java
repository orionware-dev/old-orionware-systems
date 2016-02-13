package coredependencyinjectionintegrationtests.servicedependencyinjection.impl;

import core.OrionObject;
import coredependencyinjectionintegrationtests.servicedependencyinjection.TestService;

public class TestServiceImpl extends OrionObject implements TestService
{
    @Override
    public String testThisClassIsRunning()
    {
        return "Running coredependencyinjectionintegrationtests.servicedependencyinjection.impl.TestServiceImpl...";
    }
}