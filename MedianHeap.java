package datarace;

import java.util.*;

public class MedianHeap {
	minHeap minheap = new minHeap();
	maxHeap maxheap = new maxHeap();
	public void add(int num)
	{
		if(minheap.size() == maxheap.size())
		{
			if(minheap.size() != 0 && num > minheap.peek())
			{
				maxheap.add(minheap.poll());
				minheap.add(num);
			}
			else
			{
				maxheap.add(num);
			}
		}
		else
		{
			if(num < maxheap.peek())
			{
				minheap.add(maxheap.poll());
				maxheap.add(num);
			}
			else
			{
				minheap.add(num);
			}
		}
	}

	public double getMedian()
	{
		if(minheap.size() == 0)
			return maxheap.peek();
		if(minheap.size() == maxheap.size())
		{
			return (double)(minheap.peek()+maxheap.peek()) / 2;
		}
		else
		{
			return maxheap.peek();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianHeap heap = new MedianHeap();
		heap.add(1);
		System.out.println(heap.getMedian());
		heap.add(8);
		System.out.println(heap.getMedian());
		heap.add(5);
		System.out.println(heap.getMedian());
	}

}
