package datastructuresunittests.lists.size;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import datastructures.lists.OrionList;
import datastructures.lists.factory.ListFactoryService;
import datastructures.lists.factory.impl.ListFactoryServiceImpl;
import datastructures.size.DataStructureSizeService;
import datastructures.size.impl.DataStructureSizeServiceImpl;
import tester.Concurrent;
import tester.ConcurrentJunitRunner;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 4)
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
        OrionList<DataStructureSizeTest> dataStructure = listFactoryService.createEmptyArrayList();
        DataStructureSizeService dataStructureSizeService = new DataStructureSizeServiceImpl();
        dataStructure.add(new DataStructureSizeTest());
        dataStructure.add(new DataStructureSizeTest());
        dataStructure.add(new DataStructureSizeTest());
        Assert.assertEquals(3, dataStructureSizeService.getSize(dataStructure));
    }
}