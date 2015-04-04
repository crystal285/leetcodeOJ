//space O(1),time O(n)
public class Solution {

    public void reverseWords(char[] s) {

        int i = 0, j = s.length - 1;

        reverse(s, i, j);

        int end = 0;

        int start = 0;

        while(end <= s.length)

        {

            if(end == s.length || s[end] == ' ')

            {

                reverse(s,start,end-1);

                start = end + 1;

            }

            end++;

        }

    }

    public void reverse(char[] s, int i, int j)

    {

        while(i < j)

        {

            char c = s[i];

            s[i] = s[j];

            s[j] = c;

            i++;

            j--;

        }

    }

}
