public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        while(j < n)
        {
            char ch = s.charAt(j);
            if(!set.contains(ch))
            {
                set.add(ch);
                j++;
                max = Math.max(max,j-i);
            }
            else
            {
                while(i < j && ch != s.charAt(i))
                {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }
        return Math.max(max,j-i);
    }
}