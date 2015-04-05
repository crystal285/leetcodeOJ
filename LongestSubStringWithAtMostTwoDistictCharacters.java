//time O(n),space O(1)
public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int[] exist = new int[255];

        Arrays.fill(exist,-1);

        int start = 0;

        int i = 0;

        int count = 0;

        int max = 0;

        for(int j = 0; j < s.length(); j++)

        {

            i = exist[s.charAt(j)];

            exist[s.charAt(j)] = j;

            if(i < start)

            {

                count++;

            }

            if(count == 3)

            {

                start = j-1;

                while((start-1) >= 0 && s.charAt(start-1) == s.charAt(start))

                    start--;

                count--;

            }

            max = Math.max(max,j-start+1);

        }

        return max;

    }

}
