//one pass, two pointers, swap
public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int redindex = 0,blueindex = n-1;
        int i = 0;
        while(i < blueindex+1)
        {
            if(nums[i] == 0)
            {
                swap(redindex++,i++,nums);
            }
            else if(nums[i] == 2)
            {
                swap(blueindex--,i,nums);
            }
            else i++;
        }
    }
    
    public void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}