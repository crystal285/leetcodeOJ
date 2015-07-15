//Method 2, start from the first char, compare it with all string, and then the second char
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        for(int i = 0; i < strs[0].length(); i++)
        {
            for(int j = 1; j < strs.length; j++)
            {
                if(i == strs[j].length())
                    return strs[j];
                if(strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}