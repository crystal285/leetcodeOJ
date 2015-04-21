//time O(n),moore's voting algorithm
public class Solution {

    public int majorityElement(int[] nums) {

        int num = nums[0];

        int count = 1;

        for(int i = 1; i < nums.length; i++)

        {

            if(count > 0)

            {

                if(num == nums[i])

                    count++;

                else 

                    count--;

            }

            if(count == 0)

            {

                num = nums[i];

                count++;

            }

        }

        return num;

    }

}
