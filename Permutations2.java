public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        find(lists, list, visited, nums);
        return lists;
    }
    public void find(List<List<Integer>> lists, List<Integer> list, boolean[] visited, int[] nums)
    {
        if(list.size() == nums.length)
        {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;
            if(!visited[i])
            {
                visited[i] = true;
                list.add(nums[i]);
                find(lists,list, visited,nums);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}