//Tyler Bartlett
//the project driver
// testing DLLists

public class Driver
{

	public static void main(String[] args)
	{
		DLList list = new DLList();
				
		SystemTest tester = new SystemTest();
		tester.testGetSize(list);
		tester.testIsEmpty(list);
		tester.testContains(list);
		tester.testAdd(list);
		tester.testGet(list);
		tester.testRemove(list);
	}
	
	
	
}