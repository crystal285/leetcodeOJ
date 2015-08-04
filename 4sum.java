public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4)
            return lists;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++)
        {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++)
            {
                if(j != i+1 && nums[j] == nums[j-1])
                    continue;
                int res = target - nums[i] - nums[j];
                int k = j + 1;
                int l = nums.length - 1;
                while(k < l)
                {
                    if(nums[k] + nums[l] == res)
                    {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        lists.add(list);
                        k++;
                        l--;
                        while(k < nums.length && nums[k] == nums[k-1])
                        k++;
                        while(l >= 0 && nums[l] == nums[l+1])
                        l--;
                    }
                    else if(nums[k] + nums[l] < res)
                        k++;
                    else
                        l--;
                }
            }
        }
        return lists;
    }
}