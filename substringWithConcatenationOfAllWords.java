public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if (words == null || words.length == 0 || s == null || s.length() == 0)             return ans;
        HashMap<String, Integer> map = new HashMap<String, Integer>();//store the original words information
        for(String str : words)
        {
            if(!map.containsKey(str))
            {
                map.put(str,1);
            }
            else
                map.put(str,map.get(str)+1);
        }
        int len = words[0].length();
        int size = words.length;
        if(s.length() < len * size)
            return ans;
        for(int i = 0; i <= s.length() - len * size; i++)
        {
            HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
            for(int j = 0; j < size; j++)
            {
                String strs = s.substring(i + j*len, i + (j+1) * len);
                if(!temp.containsKey(strs))
                    break;
                else
                {
                    if(temp.get(strs) == 1)
                        temp.remove(strs);
                    else
                        temp.put(strs, temp.get(strs)-1);
                }
            }
            if(temp.isEmpty())
            {
                ans.add(i);
            }
        }
        return ans;
    }
}