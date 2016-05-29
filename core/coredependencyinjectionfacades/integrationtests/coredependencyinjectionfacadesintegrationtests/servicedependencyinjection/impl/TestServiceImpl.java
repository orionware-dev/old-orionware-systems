package coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.impl;

import core.OrionObject;
import coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.TestService;

public class TestServiceImpl extends OrionObject implements TestService
{
    @Override
    public String testThisClassIsRunning()
    {
        return "Running coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.impl.TestServiceImpl...";
    }
}