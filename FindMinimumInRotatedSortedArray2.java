//worst case O(n)
public class Solution {

    public int findMin(List<Integer> nums) {

        int low = 0, high = nums.size()-1;

        while(nums.get(low) >= nums.get(high))

        {

            if(low == high)

                break;

            int mid = (low + high) / 2;

            if(nums.get(mid) < nums.get(high))

                high = mid;

            else if(nums.get(mid) > nums.get(high))

                low = mid + 1;

            else

                low++;

        }

        return nums.get(low);

    }

}
