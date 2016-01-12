package datastructuresfacades.size;

import java.util.Collection;
import datastructures.services.DataStructureFacade;

public interface DataStructureSizeFacade extends DataStructureFacade
{
    public int getSize(Collection<?> dataStructure);
}