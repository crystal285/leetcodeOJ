//time O(logn),space O(1)
public class Solution {

    public int findMin(List<Integer> nums) {

        int low = 0, high = nums.size()-1;

        while(nums.get(low) > nums.get(high))

        {

            if(low == high)

                break;

            int mid = (low + high) / 2;

            if(nums.get(mid) < nums.get(high))

                high = mid;

            else

                low = mid + 1;

        }

        return nums.get(low);

    }

}
