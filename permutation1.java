public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        find(nums, lists, list);
        return lists;
    }
    public void find(int[] nums, List<List<Integer>> lists, List<Integer> list)
    {
        if(list.size() == nums.length)
        {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(!list.contains(nums[i]))
            {
                list.add(nums[i]);
                find(nums, lists, list);
                list.remove(list.size()-1);
            }
        }
    }
}