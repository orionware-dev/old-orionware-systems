package datastructuresintegrationtests.dependencyinjection.impl;

import datastructures.DataStructuresObject;
import datastructuresintegrationtests.dependencyinjection.TestClass4;

public class TestClass4Impl extends DataStructuresObject implements TestClass4
{
    @Override
    public String testThisClassIsRunning()
    {
        return "Running datastructuresintegrationtests.dependencyinjection.impl.TestClass4Impl...";
    }
}