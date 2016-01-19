package datastructuresservicesunittests.lists.size;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.lists.OrionList;
import datastructuresservices.lists.factory.ListFactoryService;
import datastructuresservices.lists.factory.impl.ListFactoryServiceImpl;
import datastructuresservices.lists.size.ListSizeService;
import datastructuresservices.lists.size.impl.ListSizeServiceImpl;

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
        OrionList<DataStructureSizeTest> dataStructure = listFactoryService.createEmptyList(DataStructureSizeTest.class);
        ListSizeService dataStructureSizeService = new ListSizeServiceImpl();
        dataStructure.add(new DataStructureSizeTest());
        dataStructure.add(new DataStructureSizeTest());
        dataStructure.add(new DataStructureSizeTest());
        Assert.assertEquals(3, dataStructureSizeService.getSize(dataStructure));
    }
}