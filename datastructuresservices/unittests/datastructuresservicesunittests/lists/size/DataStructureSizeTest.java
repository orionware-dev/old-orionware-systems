package datastructuresservicesunittests.lists.size;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
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
        ListSizeService dataStructureSizeService = new ListSizeServiceImpl();
        OrionList<String> dataStructure = new OrionArrayList<String>();
        dataStructure.add("1");
        dataStructure.add("2");
        dataStructure.add("3");
        Assert.assertEquals(3, dataStructureSizeService.getSize(dataStructure));
    }
}