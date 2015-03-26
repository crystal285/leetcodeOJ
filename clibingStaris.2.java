//space O(1)
public class Solution {

    public int climbStairs(int n) {

        if(n == 1)

        return 1;

       int a = 1; 

       int sum = 1;

       for(int i = 2; i <= n; i++)

       {

           sum = sum + a;

           a = sum - a;

       }

       return sum;

    }

}
