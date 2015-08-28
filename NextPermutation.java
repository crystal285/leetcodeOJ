public class Solution {
    public void nextPermutation(int[] nums) {
       int n = nums.length;
       for(int i = n-2; i >= 0; i--)
       {
           if(nums[i] < nums[i+1])
           {
                int j;
                for(j = n-1; j > i; j--)
                {
                    if(nums[j] > nums[i])
                    {
                            swap(nums,i,j);
                            reverse(nums,i+1);
                            return;
                    }
                }
           }
       }
       reverse(nums,0);
    return;
    }
    public void swap(int[] nums, int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void reverse(int[] nums, int start)
    {
        int j = nums.length - 1;
        int i = start;
        while(i < j)
        {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}