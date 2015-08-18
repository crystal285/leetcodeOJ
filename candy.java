public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) return n;
        int[] candy  = new int[n];
        candy[0] = candy[n-1] = 1;
        for(int i = 1; i < n; i++)
        {
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1] + 1;
            else
                candy[i] = 1;
        }
        for(int i = n-2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1])//pay attention here, do not forget to check candy[i] and candy[i+1]
                candy[i] = candy[i+1] + 1;
        }
        int sum = 0;
        for(int num : candy)
            sum += num;
        return sum;
    }
}