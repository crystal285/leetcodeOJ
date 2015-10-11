public class minHeap {
	ArrayList<Integer> list = null;
	public minHeap()
	{
		list = new ArrayList<Integer>();
	}
	public void add(int num)
	{
		list.add(num);
		shiftUp(list.size()-1);
	}
	public void shiftUp(int pos)
	{
		while(pos > 0)
		{
			int parent = (pos-1) / 2;
			if(list.get(pos) >= list.get(parent))
				break;
			Collections.swap(list, pos, parent);
			pos = parent;
		}
	}
	public int poll()
	{
		int min = list.get(0);
		int last = list.remove(list.size()-1);
		if(!list.isEmpty())
		{
		list.set(0, last);
		shiftDown(0);
		}
		return min;
	}
	public void shiftDown(int pos)
	{
		while(pos < list.size() / 2)
		{
			int child = pos*2 + 1;
			if(child < list.size()-1 && list.get(child) > list.get(child+1))
				child++;
			if(list.get(pos) <= list.get(child))
				break;
			Collections.swap(list,pos,child);
			pos = child;
		}
	}

	public static void main(String[] args)
	{
		minHeap heap = new minHeap();
		heap.add(3);
		heap.add(1);
		heap.add(5);
		heap.add(0);
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}
}
