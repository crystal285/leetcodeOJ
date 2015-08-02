public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        int rs = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n-2; i++)
        {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = n-1;
            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target)
                    return target;
                else if(sum - target < 0)
                    left++;
                else
                    right--;
                rs = Math.abs(sum-target) < Math.abs(rs-target) ? sum : rs;
            }
        }
        return rs;
    }
}