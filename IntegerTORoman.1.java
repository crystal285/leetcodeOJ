//using TreeMap.floorKey to return the largest key that smaller and equal to the given key
public class Solution {

    public String intToRoman(int num) {

        TreeMap<Integer,String> map = new TreeMap<Integer,String>();

        map.put(1,"I");

        map.put(4,"IV");

        map.put(5,"V");

        map.put(9,"IX");

        map.put(10,"X");

        map.put(40,"XL");

        map.put(50,"L");

        map.put(90,"XC");

        map.put(100,"C");

        map.put(400,"CD");

        map.put(500,"D");

        map.put(900,"CM");

        map.put(1000,"M");

        int temp = map.floorKey(num);

        if(num == temp)

            return map.get(num);

        return map.get(temp) + intToRoman(num-temp);

    }

}
