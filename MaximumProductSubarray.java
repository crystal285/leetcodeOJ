//DP,time O(n),space O(1)
public class Solution {

    public int maxProduct(List<Integer> nums) {

        int minhere = 1;

        int maxhere = 1;

        int maxsofar = Integer.MIN_VALUE;

        for(int i = 0; i < nums.size(); i++)

        {

            int num = nums.get(i);

            int oldmax = maxhere;

            maxhere = Math.max(num,Math.max(minhere*num,maxhere*num));

            minhere = Math.min(num,Math.min(minhere*num,oldmax*num));

            maxsofar = Math.max(maxhere, maxsofar);

        }

        return maxsofar;

    }

}
