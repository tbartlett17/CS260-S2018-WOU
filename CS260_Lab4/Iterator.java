//********************************************************************************************
// Author: Tyler Bartlett
// Driver File: Driver.java
// Other Files: TreeNode.java, SystemTest.java, BSTree.java
// Date: 05/20/18
// Course: CS260
// Class time: 10am, M/W
// Lab: 3
// Desc:  Conversion of the wou junit test thing Stacia Fry emailed out on 5/18/18.
//		
//********************************************************************************************
import java.util.Vector;

public class Iterator<T extends Comparable<T>>
{
	private int current;
	Vector<T> v;
	
	public Iterator(TreeNode<T> node)
	{
		if (node == null)
		{
			current = -1;
		}
		else
		{
			v = new Vector<T>();
			treeToVector(node);
			current = 0;
		}
	}
	
	// NEED ITERATOR OPERATORS HERE
	// next() = `++`, move through the vector
	// getData = `*`, return element at v[current]
	// eqiv = `==`, is something equivalent to v[current]
	// notEquiv = `!=`, opposite of equiv
	
	private void treeToVector (TreeNode<T> node)
	{
		if (node != null)
		{
			System.out.println("node.element = " + node.element + ", node.height = " + node.height);
			treeToVector(node.left);
			v.add(node.element);
			treeToVector(node.right);
		}
	}
	
}




