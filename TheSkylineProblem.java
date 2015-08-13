public class Solution {
    class Edge
    {
        int pos;
        int height;
        boolean isStart;
        public Edge(int pos, int height, boolean isStart)
        {
            this.pos = pos;
            this.height = height;
            this.isStart = isStart;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return ans;
        }
        List<Edge> lists = new ArrayList<Edge>();
        for(int[] building : buildings)
        {
            lists.add(new Edge(building[0],building[2],true));
            lists.add(new Edge(building[1],building[2],false));
        }
        lists.sort(new Comparator<Edge>()
        {
            public int compare(Edge e1, Edge e2)
            {
                if(e1.pos != e2.pos)// 按横坐标从小到大排
                    return e1.pos - e2.pos;
                if(e1.isStart && e2.isStart)//如果横坐标相同，都是入边，按高从大到小排
                    return e2.height - e1.height;
                if(!e1.isStart && !e2.isStart)//如果横坐标相同，都是出边，按高从小到大排
                    return e1.height - e2.height;
                    return e1.isStart ? -1 : 1;//如果横坐标相同，一出一入，入在前，是拐点
            }
        });
        Queue<Integer> maxheap = new PriorityQueue<Integer>(50,Collections.reverseOrder());
        for(Edge edge : lists)
        {
            if(edge.isStart)
            {
               if(maxheap.isEmpty() || edge.height > maxheap.peek()) 
                    ans.add(new int[] {edge.pos,edge.height});
                maxheap.add(edge.height);
            }
            else
            {
                maxheap.remove(edge.height);
                if(maxheap.isEmpty())
                {
                    ans.add(new int[] {edge.pos,0});
                }
                else
                {
                    if(edge.height > maxheap.peek())
                        ans.add(new int[] {edge.pos,maxheap.peek()});
                }
            }
        }
        return ans;
    }
}