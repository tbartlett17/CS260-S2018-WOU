//********************************************************************************************
// Author: Tyler Bartlett
// Files: BSTree.java, TreeNode.java, SystemTest.java, Iterator.java
// Date: 05/20/18
// Course: CS260
// Class time: 10am, M/W
// Lab: 3
// Desc:  The "executable" for the project. 
//		
//********************************************************************************************

public class Driver
{
	public static void main (String[] args)
	{
		
		SystemTest tester = new SystemTest();
		tester.testInsert();
		tester.testGetSize();
		tester.testClear();
		tester.testIsEmpty();
		tester.testSearch();
		tester.testIterator();
		
	}
}