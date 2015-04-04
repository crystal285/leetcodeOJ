//space O(n),time O(n)
public class Solution {

    public String reverseWords(String s) {

        if(s == null || s.length() == 0)

            return s;

        int len = s.length();

        StringBuilder sb = new StringBuilder();

        int i = len - 1;

        int j;

        while(i >= 0)

        {

            if(s.charAt(i) == ' ')

                i--;

            else

            {

                j = i;

                while(i >= 0 && s.charAt(i) != ' ')

                    i--;

                    sb.append(s.substring(i+1,j+1)).append(' ');

            }

        }

        if(sb.length() != 0)

            sb.deleteCharAt(sb.length()-1);

        return sb.toString();

    }

}
