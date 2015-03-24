//bfs version
/**

 * Definition for undirected graph.

 * class UndirectedGraphNode {

 *     int label;

 *     List<UndirectedGraphNode> neighbors;

 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

 * };

 */

public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node == null)

            return null;

        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();

        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.add(node);

        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);

        map.put(node.label,newnode);

        while(!queue.isEmpty())

        {

            UndirectedGraphNode parent = queue.remove();

            UndirectedGraphNode newparent = map.get(parent.label);

            for(UndirectedGraphNode n : parent.neighbors)

            {

                if(!map.containsKey(n.label))

                {

                    UndirectedGraphNode newn = new UndirectedGraphNode(n.label);

                    queue.add(n);

                    map.put(n.label,newn);

                }

                newparent.neighbors.add(map.get(n.label));

            }

        }

        return newnode;

    }

}
