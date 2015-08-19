public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums)
            set.add(num);
        int max = 0;
        for(int num : nums)
        {
            int left = num-1; 
            int right = num+1;
            if(!set.contains(num))
                continue;
            set.remove(num);
            int local = 1;
            while(set.contains(left))
                {
                    local++;
                    set.remove(left);
                    left--;
                }
            while(set.contains(right))
            {
                local++;
                set.remove(right);
                right++;
            }
            max = Math.max(max,local);
        }
        return max;
    }
}