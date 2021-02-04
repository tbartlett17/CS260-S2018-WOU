//********************************************************************************************
// Author: Tyler Bartlett
// Driver File: Driver.java
// Other Files: BStree.java, SystemTest.java, Iterator.java
// Date: 05/20/18
// Course: CS260
// Class time: 10am, M/W
// Lab: 3
// Desc:  a class definition for a binary tree node. contains node element, node height,
//			and pointers to the node's left and right children.
//********************************************************************************************


public class TreeNode<T extends Comparable<T>>
{
	T element;  // Element contained in the node
	TreeNode left; // Pointer to the left child
	TreeNode right; // Pointer to the right child
	int height; // Height of node in tree 
	
	public TreeNode() // No-arg constructor
	{
		left = null;
		right = null;
	}
	
	public TreeNode (T element)
	{
		this.element = element;
		left = null;
		right = null;
		height = 0;
	}
	
	public T getElement()
	{
		return element;
	}
	
}