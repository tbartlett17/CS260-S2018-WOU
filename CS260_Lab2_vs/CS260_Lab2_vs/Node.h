#ifndef NODE_H
#define NODE_H
#include <iostream>
using namespace std;

template<typename T>
class Node
{
    public:
        T element; // Element contained in the node
        Node* next; // Pointer to the next node
        Node* prev; // Pointer to the previous node

        Node() // No-arg constructor
        {
            next = NULL;
            prev = NULL;
        }

        Node(T element) // Constructor
        {
            this->element = element;
            next = NULL;
            prev = NULL;
        }
};

#endif // NODE_H
