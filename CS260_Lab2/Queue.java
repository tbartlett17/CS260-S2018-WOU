

public class Queue<T>
{
	DLList list = new DLList();
	public Queue()
	{
		
	}
	
	public void enqueue(T element)
	{
		list.add(element);
	}
	
	public T dequeue()
	{
		if (list.isEmpty() == true)
		{
			return ((T)"list empty. cant dequeue.");
		}
		else
		{
			return (T)list.removeAt(0);
		}
	}
	
	public int getSize()
	{
		return list.getSize();
	}
	
	public T front()
	{
		return (T)list.get(0);
	}
	
	public T back()
	{
		return (T)list.get(list.getSize()-1);
	}
	
}