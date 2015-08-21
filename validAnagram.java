public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
           return false;
        }
        int[] exist = new int[127];
        for(int i = 0; i < s.length(); i++)
            exist[s.charAt(i)]++;
        for(int i = 0; i < t.length(); i++)
        {
            exist[t.charAt(i)]--;
            if(exist[t.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}