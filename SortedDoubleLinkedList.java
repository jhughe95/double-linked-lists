package linkedList;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	Comparator<T> comparator;
	
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) 
	{
		super();
		this.comparator= compareableObject;
		
	}
	public void add(T data)
	{	
		Node<T> newNode=new Node<T>(data);
		if(head==null&&tail==null) {
			head=newNode;
			tail=newNode;
			
			
		}else{
			Node<T> current = head;
			
			
		while(comparator.compare(newNode.data,current.data)>0)
		{
			current=current.next;
		}
			if(current==head) 
			{
				head.prev=newNode;
				newNode.next=head;
				head=newNode;
			}
			else
			{
			if(current==null) 
			{
				newNode.prev=tail;
				tail.next=newNode;
				tail=newNode;
			}
			else
			{
				current.prev.next=newNode;
				newNode.prev=current.prev;
				newNode.next=current;
				current.prev=newNode;
			}
			
			}
		}
		size++;
	}
	public Node<T> remove(T data,Comparator<T> comparator)
	{
	Node<T> current=head;
	while(comparator.compare(data,current.data)!=0)
	{
		current=current.next;
	}
	if(current==head)
	{
		head.next.prev=null;
		head.next=null;
		return head;
	}
	else
	{
	if(current==tail)
	{
		tail.prev.next=null;
		tail.prev=null;
		return tail;
	}
	else
	{
		current.prev.next=current.next;
		current.next.prev=current.prev;
		current.next=null;
		current.prev=null;
		return current;
	}
	}
	}

	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	public void addtoFront()
	{
		throw new UnsupportedOperationException();
	}
	public void addtoEnd()
	{
		throw new UnsupportedOperationException();
	}
}
