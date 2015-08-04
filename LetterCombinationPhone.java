public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> lists = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return lists;
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0',new char[] {});
        map.put('1',new char[] {});
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        StringBuffer sb = new StringBuffer();
        find(map,lists,digits,sb);
        return lists;
    }
    
    public void find(Map<Character, char[]> map,List<String> lists, String digits,StringBuffer sb)
    {
        if(sb.length() == digits.length())
        {
            lists.add(new String(sb.toString()));
            return;
        }
        for(char ch : map.get(digits.charAt(sb.length())))
        {
            sb.append(ch);
            find(map,lists,digits,sb);
            sb.deleteCharAt(sb.length()-1);   
        }
    }
    
}