//time O(mn) space O(1)
public class Solution {

    public int strStr(String haystack, String needle) {

        int m = haystack.length();

        int n = needle.length();

        if(n == 0)

            return 0;

        if(m == 0 || n > m)

            return -1;

        int i,j;

        for(i = 0; i <= m - n; i++)

        {

            for(j = 0; j < n; j++)

            {

                if(haystack.charAt(i+j) != needle.charAt(j))

                    break;

            }

            if(j == n)

                return i;

        }

        return -1;

    }

}
