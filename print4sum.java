import java.util.*;
public class print4sum {
	public static void print4sum(int[] arr)
	{
		if(arr.length < 4) return;
		HashMap<Integer,ArrayList<pair>> map = new HashMap<Integer,ArrayList<pair>>();
		for(int i = 0; i < arr.length-1; i++)
			for(int j = i + 1; j < arr.length; j++)
			{
				int key = arr[i] + arr[j];
				if(!map.containsKey(key))
				{
					ArrayList<pair> list = new ArrayList<pair>();
					map.put(key,list);
				}
				ArrayList l = map.get(key);
				pair p = new pair(i,j);
				l.add(p);
			}
		for(Integer i : map.keySet())
		{
			ArrayList<pair> list = map.get(i);
			if(list.size() > 1)
			{
				for(int j = 0; j < list.size()-1; j++)
				{
					for(int k = j+1; k < list.size(); k++)
						System.out.println(list.get(j).a + "," + list.get(j).b + "," + list.get(k).a + "," + list.get(k).b);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,7,1,2,9,8};
		print4sum(arr);
	}

}
