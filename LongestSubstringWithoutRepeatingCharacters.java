//time O(n), space O(1)
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int[] exist = new int[255];

        int max = 0;

        int start;

        int j = 0;

        for(int i = 0; i < 255; i++)

            exist[i] = -1;

        for(int i = 0; i < s.length(); i++)

        {

            start = exist[s.charAt(i)];

            exist[s.charAt(i)] = i;

            if(start >= j)

                j = start + 1;

            max = Math.max(max,i-j+1);

        }

        return max;

    }

}
