public class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> hasfound = new HashMap<>();
        int start = 0;
        int end = 0;
        int count = 0;
        int x = 0;
        int y = 0;
        int min = Integer.MAX_VALUE;
        for(Character c : t.toCharArray())
        {
            if(!map.containsKey(c))
            {
                map.put(c,0);
                hasfound.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        while(end < s.length())
        {
            char c = s.charAt(end);
            if(map.containsKey(c))
            {
            hasfound.put(c,hasfound.get(c)+1);
            if(hasfound.get(c) <= map.get(c))
                count++;
            }
            if(count == t.length())
            {
                while(true)
                {
                    char ch = s.charAt(start);
                if(map.containsKey(ch) && hasfound.get(ch) > map.get(ch))
                {
                    hasfound.put(ch,hasfound.get(ch)-1);
                    start++;
                }
                else if(!map.containsKey(ch))
                {
                    start++;
                }
                else
                    break;
                }
                if(min > end - start + 1)
                {
                    min = end-start+1;
                    x = start;
                    y = end;
                }
            }
            end++;
        }
        if(count != t.length())
        return "";
        return s.substring(x,y+1);
    }
}