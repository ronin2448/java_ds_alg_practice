package algorithms;

import algorithms.FloydCycleDetection.CustomLinkedList.Node;

public class FloydCycleDetection {
	
	public static class CustomLinkedList
	{
		public class Node{
			Integer value;
			Node next;
			
			public Node(int v)
			{
				this.value=v;
			}
		}
		
		Node head;
		
		public CustomLinkedList( int v)
		{
			this.head  = new Node(v);
		}
		
		public void add( int v )
		{
			Node c = this.head;
			Node prev = null;
			while( c != null )
			{
				prev = c;
				c = c.next;
			}
			prev.next  = new Node(v);
		}
		
	}
	
	
	public static Boolean hasCycle( CustomLinkedList cll )
	{
		Node tort = cll.head;
		Node hare = cll.head;
		while (hare!= null)
		{
			hare = hare.next;
			if( hare == tort)
			{
				return true;
			}
			hare = hare.next;
			if( hare == tort)
			{
				return true;
			}
			
			tort = tort.next;
		}
		return false;
	}

	public static void main(String[] args) {
		CustomLinkedList cll = new CustomLinkedList(1);
		cll.add(2);
		cll.add(3);
		cll.add(4);
		cll.add(5);
		cll.add(6);
		
		System.out.println( hasCycle(cll) );
		
		// cll now has a cycle
		cll.head.next.next.next.next.next =  cll.head.next.next.next;
		System.out.println( hasCycle(cll) );
	}

}
