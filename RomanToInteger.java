public class Solution {

    public int romanToInt(String s) {

        HashMap<Character,Integer> map = new HashMap<Character,Integer>(){{

            put('I',1); put('V',5); put('X',10); put('L',50); put('C',100); put('D',500); put('M',1000);

        }};

        int rs = map.get(s.charAt(0));

        for(int i = 1; i < s.length(); i++)

        {

                if(map.get(s.charAt(i)) <= map.get(s.charAt(i-1)))

                {

                    rs += map.get(s.charAt(i));

                }

                else

                {

                    rs += map.get(s.charAt(i))-2*map.get(s.charAt(i-1));

               }

        }

        return rs;

    }

}
