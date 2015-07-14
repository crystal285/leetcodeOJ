public class Solution {
    public boolean isMatch(String s, String p) {
       if(p.length() == 0)
            return s.length() == 0;
         //case 1: when the second char of p is not '*' or there is only one char, easy case.
        if(p.length() == 1 || p.charAt(1) != '*')
        {
            if(s.length() == 0)
                return false;
            else if(p.charAt(0) != s.charAt(0) && p.charAt(0) != '.')
                return false;
            else return isMatch(s.substring(1),p.substring(1));
        }
        //case 2: when the second char of p is '*', complex case.
        else
        {
            //when the '*' stands for 0 preceding element
            if(isMatch(s, p.substring(2)))
                return true;
            //when the '*' stands for 1 or more preceding element,try every possible number
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')
                {
                    if(isMatch(s.substring(i+1),p.substring(2)))
                        return true;
                }
                else
                    break;
            }
            return false;
        }   
    }
}