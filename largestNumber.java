//pay attention to how to implement comparator. Collections.sort is ascending by default
 class Solution {
    public class myComparator implements Comparator<Integer>
    {
        public int compare(Integer num1,Integer num2)
        {
            String s1 = String.valueOf(num1);
            String s2 = String.valueOf(num2);
            long rs1 = Long.parseLong(s1+s2);
            long rs2 = Long.parseLong(s2+s1);
            return (int)(rs2-rs1);
        }
    }
    public String largestNumber(int[] num) {
        List<Integer> list = new ArrayList<Integer>();
        for(int n : num)
        {
            list.add(n);
        }
        Collections.sort(list, new myComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++)
        {
                sb.append(list.get(i));
        }
        if(sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}
