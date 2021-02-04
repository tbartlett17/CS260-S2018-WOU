//********************************************************************************************
// Author: Tyler Bartlett
// Driver File: Driver.java
// Other Files: TreeNode.java, BSTree.java, Iterator.java
// Date: 05/20/18
// Course: CS260
// Class time: 10am, M/W
// Lab: 3
// Desc:  Conversion of the wou junit test thing Stacia Fry emailed out on 5/18/18.
//		
//********************************************************************************************

public class SystemTest<T extends Comparable<T>>
{
	
	public SystemTest()
	{
		
	}
	
	public void sop(String s)
	{
		System.out.println(s);
	}
	
	public void testInsert()
	{
		sop("\n********************\n*TESTING INSERT    *\n********************");
		
		BSTree tree = new BSTree();
		sop("tree must be 0 after constructor.");
		sop("size is: " + tree.getSize());
		
		sop("trying to add: 8,12,4,6,10,2,14.");
		tree.insert(8); tree.insert(12); tree.insert(4);		
		tree.insert(6); tree.insert(10); tree.insert(2);
		tree.insert(14);
		sop("tree must be 7 after adds.");
		sop("size is: " + tree.getSize());
		
		sop("search must return true for 8.");
		sop("search returns " + tree.search(8));
		sop("search must return true for 2.");
		sop("search returns " + tree.search(2));
		sop("search must return true for 10.");
		sop("search returns " + tree.search(10));
		sop("search must return true for 12.");
		sop("search returns " + tree.search(12));
	}
	
	public void testGetSize()
	{
		sop("\n********************\n*TESTING GETSIZE   *\n********************");
		
		BSTree tree = new BSTree();
		sop("tree must be 0 after constructor.");
		sop("size is: " + tree.getSize());
		
		sop("tree must be 0 after clear.");
		tree.clear();
		sop("size is: " + tree.getSize());
		
		sop("tree must be 1 after add.");
		tree.insert(10);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 2 after add.");
		tree.insert(20);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 3 after add.");
		tree.insert(30);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 4 after add.");
		tree.insert(40);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 5 after add.");
		tree.insert(15);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 6 after add.");
		tree.insert(25);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 7 after add.");
		tree.insert(35);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 8 after add.");
		tree.insert(45);
		sop("size is: " + tree.getSize());
		
		sop("tree must be 0 after clear.");
		tree.clear();
		sop("size is: " + tree.getSize());
	}
	
	public void testClear()
	{
		sop("\n********************\n*TESTING CLEAR     *\n********************");
		
		BSTree tree = new BSTree();
		
		tree.clear();
		sop("trying to add: 10,20");
		tree.insert(10);tree.insert(20);
		sop("isEmpty must return false afters adds.");
		sop("isEmpty returns " + tree.isEmpty());
		
		tree.clear();
		sop("tree must be 0 after clear.");
		sop("size is: " + tree.getSize());
		sop("isEmpty must return true afters clear.");
		sop("isEmpty returns " + tree.isEmpty());
		
		sop("trying to add: 30,40,15");
		tree.insert(30); tree.insert(40); tree.insert(15);
		sop("isEmpty must return false afters adds.");
		sop("isEmpty returns " + tree.isEmpty());
		
		tree.clear();
		sop("tree must be 0 after clear.");
		sop("size is: " + tree.getSize());
		sop("isEmpty must return true afters clear.");
		sop("isEmpty returns " + tree.isEmpty());
		
		sop("trying to add: 25,35,45");
		tree.insert(25); tree.insert(35); tree.insert(45);		
		sop("isEmpty must return false afters adds.");
		sop("isEmpty returns " + tree.isEmpty());
		
		tree.clear();
		sop("tree must be 0 after clear.");
		sop("size is: " + tree.getSize());
		sop("isEmpty must return true afters clear.");
		sop("isEmpty returns " + tree.isEmpty());
	}
	
	public void testIsEmpty()
	{
		sop("\n********************\n*TESTING ISEMPTY   *\n********************");
		BSTree tree = new BSTree();
		
		sop("isEmpty must return true after constructor.");
		sop("isEmpty returns " + tree.isEmpty());
		
		tree.clear();
		sop("isEmpty must return true afters clear.");
		sop("isEmpty returns " + tree.isEmpty());
		
		sop("trying to add: 10,20");
		tree.insert( 10);tree.insert( 20);
		sop("isEmpty must return false afters adds.");
		sop("isEmpty returns " + tree.isEmpty());
		
		sop("trying to add: 30,40,15");
		tree.insert( 30); tree.insert( 40); tree.insert( 15);
		sop("isEmpty must return false afters adds.");
		sop("isEmpty returns " + tree.isEmpty());
		
		sop("trying to add: 5,1,25");
		tree.insert( 5); tree.insert( 1); tree.insert( 25);
		sop("isEmpty must return false afters adds.");
		sop("isEmpty returns " + tree.isEmpty());
		
		tree.clear();
		sop("isEmpty must return true afters clear.");
		sop("isEmpty returns " + tree.isEmpty());
		
		sop("trying to add: 10,20");
		tree.insert( 10); tree.insert( 20);
		sop("isEmpty must return false afters adds.");
		sop("isEmpty returns " + tree.isEmpty());
	}
	
	public void testSearch()
	{
		sop("\n********************\n*TESTING SEARCH    *\n********************");
		
		BSTree tree = new BSTree();
		
		sop("trying to add: 10,20,30,40,15,25,5,5,1");
		tree.insert(10); tree.insert(20);tree.insert(30);
		tree.insert(40); tree.insert(15); tree.insert(25);
		tree.insert(5); tree.insert(5); tree.insert(1);
		
		sop("search must return false for 80.");
		sop("search returns " + tree.search(80));
		sop("search must return false for 3.");
		sop("search returns " + tree.search(3));
		sop("search must return true for 10.");
		sop("search returns " + tree.search(10));
		sop("search must return true for 5.");
		sop("search returns " + tree.search(5));
		sop("search must return true for 1.");
		sop("search returns " + tree.search(1));
		sop("search must return true for 20.");
		sop("search returns " + tree.search(20));
		sop("search must return true for 25.");
		sop("search returns " + tree.search(25));
		sop("search must return true for 40.");
		sop("search returns " + tree.search(40));
		
		tree.clear();
		sop("search must return false for 10 after clear.");
		sop("search returns " + tree.search(10));
	}
	
	public void testIterator()
	{
		sop("\n********************\n*TESTING ITERATOR  *\n********************");
		
		int sum = 0;
		BSTree tree = new BSTree();
		
		sop("trying to add: 1,2,3,4,5,6,7,8,9");
		tree.insert(1); tree.insert(2); tree.insert(3);
		tree.insert(4); tree.insert(5);
		tree.insert(6); tree.insert(7);
		tree.insert(8); tree.insert(9);
		sop("add complete");
		
		Iterator it = tree.begin();
		for(int i = 0; i < it.v.size(); i++)
		{
			int num = (int)it.v.get(i);
			sum = sum + num;
		}
		
		sop("sum of BST/vector must be 45");
		sop("sum is: " + sum);
	}
}




