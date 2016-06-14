package datastructuresservicesunittests.lists.size;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.ListFactoryServiceImpl;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.DataStructureSizeServiceImpl;

public class DataStructureSizeTest
{
    @Before
    public void setUp() throws Exception
    {

    }


    @Test
    public void testDataStructureSize()
    {
        ListFactoryService<DataStructureSizeTest> listFactoryService = new ListFactoryServiceImpl<DataStructureSizeTest>();
        OrionList<DataStructureSizeTest> dataStructure = listFactoryService.createEmptyArrayList(DataStructureSizeTest.class);
        DataStructureSizeService dataStructureSizeService = new DataStructureSizeServiceImpl();
        dataStructure.add(new DataStructureSizeTest());
        dataStructure.add(new DataStructureSizeTest());
        dataStructure.add(new DataStructureSizeTest());
        Assert.assertEquals(3, dataStructureSizeService.getSize(dataStructure));
    }
}