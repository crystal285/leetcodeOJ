//time O(logn),space O(logn)
public class Solution {

    public int findMin(List<Integer> nums) {

        return find(nums,0,nums.size()-1);

    }

    

    private int find(List<Integer> nums, int low, int high)

    {

        if(low == high)

            return nums.get(low);

        int mid = (low + high) / 2;

        if(nums.get(mid) < nums.get(high))

            return find(nums,low,mid);

        else

            return find(nums,mid+1,high);

    }

}
