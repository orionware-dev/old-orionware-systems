package datastructuresunittests.lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionArrayList;
import tester.Concurrency;
import tester.ConcurrentJUnitRunner;

@RunWith(ConcurrentJUnitRunner.class)
@Concurrency()
public class OrionListTest extends DataStructuresObject
{
    private OrionList<Integer> filteredList;
    private OrionList<Integer> expectedFilteredList;


    @Before
    public void setUp() throws Exception
    {
        filteredList = new OrionArrayList<Integer>();
        expectedFilteredList = new OrionArrayList<Integer>();
        expectedFilteredList.add(4);
        expectedFilteredList.add(5);
        expectedFilteredList.add(6);
    }


    @Test
    public void testListFilterAndLoop()
    {
        OrionList<Integer> list = new OrionArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.filterAndLoop((Integer s) -> s > 3, this::getFilteredList);
        Assert.assertArrayEquals(filteredList.toArray(), expectedFilteredList.toArray());
    }


    private void getFilteredList(Object number)
    {
        int numberTemp = (int)number;
        filteredList.add(numberTemp);
    }
}