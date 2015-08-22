public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s : strs)
        {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        for(List<String> list : map.values())
        {
            Collections.sort(list);
            lists.add(list);
        }
        return lists;
    }
}