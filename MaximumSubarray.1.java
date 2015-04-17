//DP,time O(n),space O(1)
public class Solution {

    public int maxSubArray(List<Integer> nums) {

        int maxhere = 0;

        int maxsofar = Integer.MIN_VALUE;

        for(int num : nums)

        {

            maxhere = Math.max(maxhere+num,num);

            maxsofar = Math.max(maxsofar,maxhere);

        }

        return maxsofar;

    }

}
