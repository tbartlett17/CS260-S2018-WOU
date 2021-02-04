
public class DLList<T>
{
	private Node head;
	private Node tail;
	private int size;
	
	public DLList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	private class Node
	{
        T element; // Element contained in the node
		Node next; // Pointer to the next node
		Node prev; // Pointer to the previous node

		public Node() // No-arg constructor
		{
			next = null;
			prev = null;
		}

		public Node(T element) // Constructor
		{
			this.element = element;
			next = null;
			prev = null;
		}
    }
	//create new node, add at end of list
	public void add(T element)
	{
		Node newNode = new Node(element);
		if (size == 0)
		{
			head = tail = newNode;
		}
		else
		{
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			tail.next = null;
		}
		size++;
	}
	
	public void addAt(T element, int index)
	{
		if (index < 0 || index > size)
		{
			System.out.println("Error: bad index");
			System.exit(0);
		}
		
		Node newNode = new Node(element);
		if (index == 0) // add to start
		{
			newNode.next = head;
			head = newNode;
		}
		else if (index == size) // add to end
		{
			add(element);
		}
		else // add to middle
		{
			Node prevNode = head;
			for (int i = 0; i < index-1; i++)
			{
				prevNode = prevNode.next;
			}
			//reset poinjters to neighbor nodes
			newNode.prev = prevNode;
			newNode.next = prevNode.next;
			newNode.next.prev = newNode;
			newNode.prev.next = newNode;
		}
		size++;
	}
	
	//empty list
	public void clear()
	{
		while ( size > 0)
		{
			//System.out.println("size is " + size);
			//System.out.println("trying to remove element...");
			removeAt(size-1);
		}
	}
	
	public boolean contains(T element)
	{
		boolean foundFlag = false; 
		Node curNode = head;
		while (curNode != null)
		{
			if (curNode.element == element)
			{
				foundFlag = true;
				break;
			}
			else
			{
				curNode = curNode.next;
			}
		}
		return foundFlag;	
	}
	
	// get element at index
	public T get(int index)
	{
		if (index < 0 || index > size-1)
		{
			System.out.println("Error: bad index");
			System.exit(0);
		}
		T tempElem = null;
		if (index == 0)
		{
			tempElem = head.element;
		}
		else if (index == size - 1)
		{
			tempElem = tail.element;
		}
		else
		{
			Node curNode = head;
			int i = 0;
			while (curNode != null)
			{
				if (i == index)
				{
					tempElem = curNode.element;
					break;
				}
				i++;
				curNode = curNode.next;
			}
		}
		return tempElem;
	}
	
	//is the list empty?
	public boolean isEmpty()
	{
		if (size == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//walk through list
	public Node iterator(int index, Node tmpNode)
	{
		// I could have been more efficient had I used this
		// iterator but I felt that its use case was too
		// general for my implementation needs 
		
		return tmpNode;
	}
	
	//remove the specified element
	public T remove(T element)
	{
		boolean found = false;
		T tempElem = null;
		Node curNode = head;
		while (curNode != null)
		{
			if (curNode.element == element)
			{
				found = true;
				break;
			}
			else
			{
				curNode = curNode.next;
			}
		}	
		if (!found)
		{
			System.out.println("element not in list. Nothing to remove.");
		}
		else
		{
			tempElem = curNode.element;
			curNode.prev.next = curNode.next;
			curNode.next.prev = curNode.prev;
			System.out.println("removed " + element + " from list");
			size--;
		}		
	
	return tempElem;
	}
	
	//remove element at specified index
	public T removeAt(int index)
	{
		
		if (index < 0 || index > size-1)
		{
			System.out.println("Error: bad index");
			System.exit(0);
		}
		
		T tempElem = null;
		if (index == 0) // delete node at head
		{
			if (size == 0 || size == 1)
			{
				//doing this might make a memory leak???
				//but it stops the nullPointerException
			}
			else
			{	
				tempElem = head.element;
				head = head.next;
				head.prev.next = null;
				head.prev  = null;
			}
		}
		else if (index == size-1) // delete node at tail
		{
			tempElem = tail.element;
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
		}
		else // delete node from middle
		{
			//System.out.println("trying to delete frrom middle...");
			Node prevNode = head;
			for (int i = 0; i < index-1; i++)
			{
				prevNode = prevNode.next;
			}
			//System.out.println("walked prevNode up to spot " + index);
			//reset poinjters to neighbor nodes
			
			
			tempElem = prevNode.next.element;
			
			//System.out.println("tempElem = " + tempElem);
			prevNode.next = prevNode.next.next;
			//System.out.println("finished setting prevNode.next = prevNode.next.next");
			prevNode.next.prev = prevNode;
			
		}
		size--;
		return tempElem;
	}
	
	public int getSize()
	{
		return size;
	}
	
	
}


