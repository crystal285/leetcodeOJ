public class Solution {
    public int singleNumber(int[] A) {
        int[] a = new int[32];
        int rs = 0;
        for(int j = 31; j >= 0 ; j--)
        {
            for(int num : A)
            {
            a[j] += ((num >> j) & 1) == 1 ? 1 : 0;
            }
            a[j] = a[j] % 3;
            rs = (rs << 1) | a[j];
        }    
        return rs;
    }
}