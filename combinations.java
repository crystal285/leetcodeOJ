//dfs and backtracking
public class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        List<Integer> list = new ArrayList<Integer>();

        find(n,k,lists,list,1);

        return lists;

    }

    public void find(int n, int k, List<List<Integer>> lists, List<Integer> list, int start)

    {

        if(k == 0)

        {

            lists.add(new ArrayList<Integer>(list));

            return;

        }

        for(int i = start; i <= n; i++)

        {

            list.add(i);

            find(n,k-1,lists,list,i+1);

            list.remove(list.size()-1);

        }

    }

}
