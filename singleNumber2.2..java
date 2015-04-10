public class Solution {
    public int singleNumber(int[] A) {
        //using 00,01,10 to represent the three states.
        int bit1 = 0;//low bit
        int bit2 = 0;//high bit
        for(int i = 0; i < 32; i++)
        {
            for(int num : A)
            {
                if( ( (1 << i) & num) != 0)
                {
                    if(( (1 << i) & bit1) == 0)
                    {
                        if(( (1 << i) & bit2) == 0)
                            bit1 |= 1 << i;
                        else
                            bit2 &= ~(1 << i); 
                    }
                    else
                    {
                        bit1 &= ~(1 << i);
                        bit2 |= 1 << i;
                    }
                }
            }
        }
        return bit1;
    }
}