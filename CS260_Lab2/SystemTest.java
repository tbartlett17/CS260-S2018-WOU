

public class SystemTest
{
	
	public SystemTest()
	{
		
	}
	
	public void printList (DLList list)
	{
		if (list.getSize() == 0)
		{
			System.out.println("List is empty. nothing to print.");
		}
		for (int i = 0; i < list.getSize(); i++)
		{
			System.out.println("value in list: " + list.get(i));
		}	
	}
	
	public void testGetSize(DLList list)
	{
		System.out.println("Size must be 0 after constructor");
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 0 after clear");
		list.clear();
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 1 after first add");
		list.add("30");
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 2 after second add");
		list.add("40");
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 3 after third add");
		list.add("15");
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 4 after fourth add");
		list.add("25");
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 5 after fifth add");
		list.add("45");
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 4 after first remove");
		list.removeAt(0);
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 3 after second remove");
		list.removeAt(2);
		System.out.println("Size is: " + list.getSize());
		
		System.out.println("Size must be 0 after clear");
		list.clear();
		System.out.println("Size is: " + list.getSize());
		
		//System.out.println("data in spot 0: " + list.get(0));
		//System.out.println("data in spot 1: " + list.get(1));
		printList(list);
	}
	
	public void testIsEmpty(DLList list)
	{
		System.out.println("isEmpty returns true after constructor");
		System.out.println("isEmpty: " + list.isEmpty());
		
		System.out.println("isEmpty returns true after clear");
		list.clear();
		System.out.println("isEmpty: " + list.isEmpty());
		
		System.out.println("isEmpty returns false after adds (adding 2 things)");
		list.add("10");
		list.add("20");
		System.out.println("isEmpty: " + list.isEmpty());
	
		System.out.println("isEmpty returns false after adds (adding 3 more things)");
		list.add("30");
		list.add("40");
		list.add("15");
		System.out.println("isEmpty: " + list.isEmpty());
		
		System.out.println("isEmpty returns false after adds (adding 3 more things)");
		list.add("25");
		list.add("35");
		list.add("45");
		System.out.println("isEmpty: " + list.isEmpty());
		
		System.out.println("isEmpty returns true after clear");
		list.clear();
		System.out.println("isEmpty: " + list.isEmpty());
	}
	
	public void testContains(DLList list)
	{
		list.clear();
		System.out.println("adding 10,20,30,40,15,25,35,45 to list");
		list.add("10");
		list.add("20");
		list.add("30");
		list.add("40");
		list.add("15");
		list.add("25");
		list.add("35");
		list.add("45");	
		
		System.out.println("Contains returns false for 80");
		System.out.println("80 in list? - " + list.contains("80"));
		
		System.out.println("Contains returns false for 5");
		System.out.println("5 in list? - " + list.contains("5"));
		
		System.out.println("Contains returns true for 30");
		System.out.println("30 in list? - " + list.contains("30"));
		
		System.out.println("Contains returns true for 45");
		System.out.println("45 in list? - " + list.contains("45"));
		
		System.out.println("Contains returns true for 10");
		System.out.println("10 in list? - " + list.contains("10"));
		
		System.out.println("clearing list");
		list.clear();
		
		System.out.println("Contains returns false for 45");
		System.out.println("45 in list? - " + list.contains("45"));
	}
	
	public void testAdd(DLList list)
	{
		list.add("10");
		System.out.println("adding 10 to list");
		System.out.println("tail must be 10 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
		list.add("20");
		System.out.println("adding 20 to list");
		System.out.println("tail must be 20 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
		list.add("30");
		System.out.println("adding 30 to list");
		System.out.println("tail must be 30 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
		list.add("40");
		System.out.println("adding 40 to list");
		System.out.println("tail must be 40 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
		list.add("15");
		System.out.println("adding 15 to list");
		System.out.println("tail must be 15 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
		list.add("25");
		System.out.println("adding 25 to list");
		System.out.println("tail must be 25 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
		list.add("35");
		System.out.println("adding 35 to list");
		System.out.println("tail must be 35 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
		list.add("45");	
		System.out.println("adding 45 to list");
		System.out.println("tail must be 45 after add");
		System.out.println("" + list.get(list.getSize() - 1));
		
	}
	
	public void testGet(DLList list)
	{
		System.out.println("adding 10,20,30,40,15,25,35,45 to list");
		list.add("10");
		list.add("20");
		list.add("30");
		list.add("40");
		list.add("15");
		list.add("25");
		list.add("35");
		list.add("45");	
		
		System.out.println("head of list must be 10 after the adds");
		System.out.println("value at head: " + list.get(0));
		
		System.out.println("tail of list must be 45 after the adds");
		System.out.println("value at tail: " + list.get(7));
		
		System.out.println("4th item of list must be 40 after the adds");
		System.out.println("value at head: " + list.get(3));
		
		System.out.println("6th item of list must be 25 after the adds");
		System.out.println("value at head: " + list.get(5));
	}
	
	public void testRemove(DLList list)
	{
		System.out.println("adding 10,20,30,40,15,25,35,45 to list");
		list.clear();
		list.add("10");
		list.add("20");
		list.add("30");
		list.add("40");
		list.add("15");
		list.add("25");
		list.add("35");
		list.add("45");
	
		System.out.println("remove returns false for 99");
		list.remove("99");
		System.out.println("size must be 8 aftrer failed remove. size: " + list.getSize());
		
		System.out.println("remove returns true for 45: ");
		list.remove("45");
		System.out.println("45 IN LIST? - " + list.contains("45"));
		System.out.println("size must be 7 aftrer failed remove. size: " + list.getSize());
		
		
	}
}