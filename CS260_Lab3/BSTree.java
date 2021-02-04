//********************************************************************************************
// Author: Tyler Bartlett
// Driver File: Driver.java
// Other Files: TreeNode.java, SystemTest.java, Iterator.java
// Date: 05/20/18
// Course: CS260
// Class time: 10am, M/W
// Lab: 3
// Desc:  some of the associated methods to a binary search.
//		
//********************************************************************************************
import java.lang.Math;

public class BSTree<T extends Comparable<T>>
{
	private TreeNode<T> root;
	private int treeSize;
	private Iterator<T> it;
	
	public BSTree()
	{
		root = null;
		treeSize = 0;
	}
	
	public boolean insert (T element)
	{
		TreeNode<T> newNode = new TreeNode<T>(element);
		
		if (isEmpty())
		{
			root = newNode;
			newNode.height = 0;
			treeSize = 1;
			return true;
		}
		else
		{
			//fixHeight(root);
			return insert (root, newNode);
			
		}
		//return true;
	}
	
	public boolean insert(TreeNode<T> curNode, TreeNode<T> newNode)
	{
		// compareTo() returns -,0,+ if x < y, x == y, x > y  
		if (newNode.element.compareTo(curNode.element) < 0)
		{
			if (curNode.left == null)
			{
				curNode.left = newNode;
				treeSize++;
			}
			else 
			{
				return insert (curNode.left, newNode);
			}
		}
		else if (newNode.element.compareTo(curNode.element) > 0)
		{
			if (curNode.right == null)
			{
				curNode.right = newNode;
				treeSize++;
			}
			else 
			{
				return insert (curNode.right, newNode);
			}
		}
		else //new node element == curNode element. do not add
		{
			System.out.println("Error adding " + newNode.element + "." + newNode.element + " was already in tree");
		}
		return false; // should only be tripped if above returns are missed? aka elements are equal
	}
	
	public void clear()
	{
		// java garbage collector so good
		root = null;
		treeSize = 0;		
	}

	public boolean search(T element)
	{
		return search(root, element);
	}
	
	public boolean search(TreeNode<T> node, T element)
	{
		boolean found = false;
		
		while ((node != null) && !found)
        {
			if (element.compareTo(node.element) < 0)
			{
				node = node.left;
			}
			else if (element.compareTo(node.element) > 0)
			{
				node = node.right;
			}
			else // node element == element
			{
				found = true;
				break;
			}
			found = search(node, element);
		}
		return found;
	}
	
	public boolean isEmpty()
	{
		if (treeSize == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	public int getSize()
	{
		return treeSize;
	}
	
	public Iterator<T> begin()
	{
		it = new Iterator<T>(root); 
		return (it);
	}
	
	public Iterator<T> end()
	{
		it = new Iterator<T>(null);
		return (it); // end of BST is null so return null iterator
	}
	
	public void fixHeight(TreeNode<T> node)
	{
		if (treeSize == 0)
		{
			return;
		}
		else if (treeSize == 1)
		{
			node.height = 0;
		}
		else if(node.left != null && node.right != null && treeSize > 1)
		{
			node.height = 0;
		}
		else if (node.left == null)
		{
			node.height = 1 + node.right.height;
		}
		else if (node.right == null)
		{
			node.height = 1 + node.left.height;
		}
		else
		{
			fixHeight(node.left);
			fixHeight(node.right);
		}
		
		if(node.left != null && node.right != null)
		{
			node.height = Math.max(node.left.height, node.right.height);
		}
	}
	
	
}




