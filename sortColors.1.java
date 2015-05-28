//two pass, counting sort
public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int i = 0; i < nums.length; i++)
        {
            switch(nums[i])
            {
            case 0 : red++;
                    break;
            case 1 : white++;
                    break;
            case 2 : blue++;
                    break;
            }
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(red > 0)
            {
                nums[i] = 0;
                red--;
                continue;
            }
            if(white > 0)
            {
                nums[i] = 1;
                white--;
                continue;
            }
            nums[i] = 2;
        }
    }
}