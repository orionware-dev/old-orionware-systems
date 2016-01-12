package core.services;

import core.general.OrionInterface;

public interface OrionTask extends OrionInterface
{
    public Object execute(Object... methodParameters);
    
    
    public Object[] executeAndReturnArray(Object... methodParameters);
}