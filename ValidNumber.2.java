public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s == null || s.length() == 0)
            return false;
        int i = 0;
        int len = s.length();
        if(s.charAt(i) == '+' || s.charAt(i) == '-')
            i++;
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        while(i < len)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = true;
            }
            else if(c == '.')
            {
                if(dot || exp) return false;
                dot = true;
            }
            else if(c == 'e')
            {
                if(exp || !num) return false;
                if(i+1 < len && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-'))
                    i++;
                num = false;
                exp = true;
            }
            else
                return false;
            i++;
        }
        return num;
    }
}