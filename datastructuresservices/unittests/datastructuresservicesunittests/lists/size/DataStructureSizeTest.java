package datastructuresservicesunittests.lists.size;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructuresservices.lists.size.DataStructureSizeService;
import datastructuresservices.lists.size.impl.DataStructureSizeServiceImpl;

public class DataStructureSizeTest
{
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    
    @Test
    public void testDataStructureSize()
    {
        DataStructureSizeService dataStructureSizeService = new DataStructureSizeServiceImpl();
        OrionList<String> dataStructure = new OrionArrayList<String>();
        dataStructure.add("1");
        dataStructure.add("2");
        dataStructure.add("3");
        Assert.assertEquals(3, dataStructureSizeService.getSize(dataStructure));
    }
}