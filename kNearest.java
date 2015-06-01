public class Point
{
	double x;
	double y;
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}

public static class myComparator implements Comparator<Point>
{
	public int compare(Point p1, Point p2)
	{
		return (int) ((p2.x * p2.x + p2.y * p2.y) - (p1.x * p1.x + p1.y * p1.y));
	}
}

public class knearest {
	public static void knearest(List<Point> list, int k)
	{
		Queue<Point> maxheap = new PriorityQueue<Point>(k, new myComparator());
		for(Point p : list)
		{
			if(maxheap.size() < k)
				maxheap.add(p);
			else
			{
				Point top = maxheap.peek();
				if(top.x * top.x + top.y * top.y - p.x * p.x - p.y * p.y > 0)
				{
					maxheap.poll();
					maxheap.add(p);
				}
			}
		}
		while(!maxheap.isEmpty())
		{
			//System.out.println(maxheap.size());
			Point p = maxheap.poll();
			System.out.println(p.x + " " + p.y);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1,1));
		list.add(new Point(2,1));
		list.add(new Point(5,5));
		list.add(new Point(4,4));
		list.add(new Point(3,3));
		knearest(list, 3);
	}

}
