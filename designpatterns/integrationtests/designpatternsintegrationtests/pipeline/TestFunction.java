package designpatternsintegrationtests.pipeline;

import core.functions.OrionFunction;

@FunctionalInterface
public interface TestFunction extends OrionFunction
{
    public Object functionName();
}