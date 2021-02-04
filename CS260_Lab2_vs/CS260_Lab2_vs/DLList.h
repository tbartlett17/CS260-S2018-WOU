#ifndef DLLIST_H
#define DLLIST_H
#include "Node.h"
#include "DLListIterator.h"
#include <iostream>
#include <stdexcept>
using namespace std;


template<typename T>
class DLList
{
private:
	Node<T>* head;
	Node<T>* tail;
	int size;
public:
	DLList();
	void add(T element);
	void add(int index, T element);
	void clear();
	const bool contains(T element);
	const T get(int index);
	const bool isEmpty();
	T remove(T element);
	T removeAt(int index);
	const int getSize();
};

//no-arg constructor
template<typename T>
DLList<T>::DLList()
{
	head = NULL;
	tail = NULL;
	size = 0;
}

//create new node, add at end of list
template<typename T>
void DLList<T>::add(T element)
{
	Node<T>* newNode = new Node<T>(element);
	if (size == 0)
	{
		head = newNode;
		tail = newNode;
	}
	else
	{
		newNode->prev = tail;
		tail->next = newNode;
		tail = newNode;
		tail->next = NULL;
	}
	size++;
}

//create new node, add at index
template<typename T>
void DLList<T>::add(int index, T element)
{
	Node<T>* newNode = new Node<T>(element);
	if (index < 0 || index > size)
	{
		throw out_of_range("out of range: index out of list size");
	}

	if (index == 0) // add to start
	{
		newNode->next = head;
		head = newNode;
	}
	else if (index == this->size) //add to end
	{
		add(element);
	}
	else // add in middle
	{
		Node<T>* prevNode = head;
		for (int curNode = 0; curnode < index - 1; curNode++)
		{
			prevNode = prevNode->next;
		}
		//reset pointers of adjacent nodes
		newNode->prev = prevNode;
		newNode->next = prevNode->next;
		newNode->next->prev = newNode;
		newNode->prev->next = newNode;
	}
	size++;
}

template<typename T>
void DLList<T>::clear()
{
	//need remove method
}

//check if list contains element
template<typename T>
const bool DLList<T>::contains(T element)
{
	Node<T>* curNode = head;
	int i = 0;
	while (curNode != NULL)
	{
		if (curNode->element == element)
		{
			return true;
			break;
		}
		i++;
	}
	if (i >= size)
	{
		return false;
	}
}

//get element at index
template<typename T>
const T DLList<T>::get(int index)
{
	Node<T>* newNode = new Node<T>(element);
	if (index < 0 || index > size)
	{
		throw out_of_range("out of range: index out of list size");
	}

	if (index == 0)
	{
		return head->element;
	}
	else if (index == size - 1)
	{
		return tail->element;
	}
	else
	{
		Node<T>* curNode = head;
		int i = 0;
		while (curNode != NULL)
		{
			if (i == index)
			{
				return curNode->element;
				break
			}
			i++;
			curNode = curNode->next;
		}
	}
}

//is the list empty?
template<typename T>
const bool DLList<T>::isEmpty()
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

//removes a node at end of list
template<typename T>
T DLList<T>::remove(T element)
{
	if (size == 0)
	{
		throw runtime_error("No elements in list");
	}
	else if (size == 1)
	{
		Node<T>* temp = head;
		head = tail = NULL;
		size = 0;
		T elemRtn = temp->element;
		delete temp;
		temp = NULL;
	}
	else
	{
		node 
	}
}

template<typename T>
T DLList<T>::removeAt(int index)
{
	Node<T>* curNode = head;
	for (int i = 0; i < size - 1; i++)
	{
		curNode = curNode->next;

	}
}

template<typename T>
const int DLList<T>::getSize()
{
    return size;
}


#endif // DLLIST_H
