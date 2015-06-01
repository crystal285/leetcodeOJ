public class flattenList
{
	public Node flatten(Node head)
	{
		if(head == null)
			return null;
		Node dummy = new Node(0);
		dummy.next = head;
		Node pre = dummy;
		Node cur = head;
		while(cur != null)
		{
			if(cur.childlist != null)
			{
				Node temp = flatten(cur.childlist);
				dummy.next = temp;
				cur.childlist = null;
				while(temp.next != null)
					temp = temp.next;
				temp.next = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return dummy.next;
	}

	
}