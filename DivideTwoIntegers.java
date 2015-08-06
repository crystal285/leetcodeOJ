public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        long x = dividend;
        long y = divisor;
        if(x < 0)
        {
            sign *= -1;
            x = x * -1;
        }
        if(y < 0)
        {
            sign *= -1;
            y = y * -1;
        }
        if(x < y)
            return 0;
        long rs = 0;
        long multi;
        long y1;
        while(x >= y)
        {
            multi = 1;
            y1 = y;
           while(x >= (y1 << 1))
           {
            y1 <<= 1;
            multi <<= 1;
           }
            x -= y1;
            rs += multi;
        }
        long result = rs * sign;
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } 
        else if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else { 
            return (int) result;
        }   
    }
}