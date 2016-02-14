package designpatternsintegrationtests.pipeline;

import core.general.functions.OrionFunction;

@FunctionalInterface
public interface TestFunction extends OrionFunction
{
    public Object functionName();
}