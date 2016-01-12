package datastructuresservices.size;

import java.util.Collection;
import datastructures.services.DataStructureService;

public interface DataStructureSizeService extends DataStructureService
{
    public int getSize(Collection<?> dataStructure);
}