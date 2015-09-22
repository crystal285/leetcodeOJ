public class Solution {
    public String countAndSay(int n) {
        StringBuilder current = new StringBuilder();
        current.append("1");
        for(int i = n; i > 1; i--)
        {
            StringBuilder parent = current;
            current = new StringBuilder();
            for(int j = 0; j < parent.length();j++)
            {
                int count = 1;
                while(j < parent.length()-1 && parent.charAt(j) == parent.charAt(j+1))
                {
                    j++;
                    count++;
                }
                current.append(String.valueOf(count)+parent.charAt(j));
            }
        }
        return current.toString();
    }
}