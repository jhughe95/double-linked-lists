package linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{
	int size;
	 Node<T> head;
	 Node<T> tail;
	public class DoubleLinkedListIterator implements ListIterator<T>
	{
	Node<T> temp;
	
	
	public DoubleLinkedListIterator()
	{
		temp = head;
	}


		@Override
		public boolean hasNext() {
			if(temp.next!=null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		@Override
		public T next() {
			if(hasNext())
			{
				T dataOfTemp=temp.data;
				temp=temp.next;
				return dataOfTemp;
			}
			else 
			{
				throw new NoSuchElementException();
			}
		
		}

		@Override
		public boolean hasPrevious() {
	if(temp.prev!=null)
	{
		return true;
	}
	else
	{
		return false;
	}
		}

		@Override
		public T previous() {
			if(hasPrevious()) 
			{
				T dataOfPrev=temp.prev.data;
				temp=temp.prev;
				return dataOfPrev;
			}
			else
			{
				throw new NoSuchElementException();
			}
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	
	
public class Node<T>
{
	T data;
	Node<T> next;
	Node<T> prev;
	Node (T data)
	{
		this.data=data;
	}
}
	public int getSize()
	{
		return size;
	}

	BasicDoubleLinkedList()
	{
		head=null;
		tail=null;
		size=0;
	}
	public void addToEnd(T data)
	{
		Node<T> newNode= new Node<T>(data);
		if(getSize()==0)
		{
			head=newNode;
			tail=newNode;
			size++;
		}
		else
		{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			size++;
		}
	}
	
	public void addToFront(T data) 
	{
		Node<T> newNode= new Node<T>(data);
		if(getSize()==0)
		{
			head=newNode;
			tail=newNode;
			size++;
		}
		else 
		{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
			size++;
		}
	}
	
	public T getFirst() 
	{
		return head.data;
	}
	public T getLast() 
	{
		return tail.data;
	}
	
	public ListIterator<T> iterator()
	{
	return new DoubleLinkedListIterator();
	}

	public T retrieveFirstElement() 
	{
		if(head==null)
		{
			return null;
		}
		else
		{
			T dataOfFirst=head.data;
			head.next.prev=null;
			head=head.next;
			return dataOfFirst;
		}
	}
	public T retrieveLastElement() 
	{
		if (tail==null) 
		{
			return null;
		}
		else
		{
			T dataOfLast=tail.data;
			tail.prev.next=null;
			tail=tail.prev;
			return dataOfLast;
		}
	}
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> list=new ArrayList<T>();
		Node<T> temp=head;
		while(temp!=null)
		{
			list.add(temp.data);
			temp=temp.next;
		}
		return list;
	}
	public Node<T> remove(T targetData,Comparator<T> comparator)
	{
		Node<T> current=head;
		if(current==null)
		{
			return null;
		}
		else
		{
			
			while(comparator.compare(targetData, current.data)!=0&&current!=null)
			{
				current=current.next;
			}
			if(current==head) 
			{
				head=current.next;
				if(head!=null) 
				{
					head.prev=null;
				}
				else
				{
					tail=null;
				}
			}
			else 
			{
				if(current==tail)
				{
					tail=current.prev;
					tail.next=null;
				}else {
					current.prev.next=current.next;
					current.next.prev=current.prev;
				}
				size--;
				current.next=null;
				current.prev=null;
				return current;
				
			}
			
		}
		return null;
	}
	
	





}
