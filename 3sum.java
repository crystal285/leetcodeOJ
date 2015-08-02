public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3)
            return lists;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-2; i++)//not i < n
        {
            if(i != 0 && nums[i] == nums[i-1])//remove duplicate
                continue;
            if(nums[i] > 0)
                break;
            int left = i + 1;
            int right = n - 1;
            while(left < right)
            {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0)
                {
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(nums[i]);
                    triple.add(nums[left]);
                    triple.add(nums[right]);
                    lists.add(triple);
                    left++;
                    right--;
                    while(left < n && nums[left] == nums[left-1]) //remove duplicate
                        left++;
                    while(right >= 0 && nums[right] == nums[right+1])//remove duplicate
                        right--;
                }
                else if(sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return lists;
    }
}