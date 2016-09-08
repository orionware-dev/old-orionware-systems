package datastructuresunittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import datastructuresunittests.lists.OrionListTest;
import datastructuresunittests.lists.size.DataStructureSizeTest;

@RunWith(Suite.class)
@SuiteClasses({OrionListTest.class,
                DataStructureSizeTest.class})
public class DataStructuresUnitTestsSuite
{

}