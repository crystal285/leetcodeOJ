public class Solution {

    public int[] plusOne(int[] digits) {

        int len = digits.length;

        int carry = (digits[len-1] + 1) / 10;

        digits[len-1] = (digits[len-1] + 1) % 10;

        for(int i = len-2; i >= 0; i--)

        {

            int temp = digits[i] + carry;

            digits[i] = temp % 10;

            carry = temp / 10;

        }

        if(carry == 1)

        {

            int[] rs = new int[len+1];

            rs[0] = 1;

            for(int i = 0; i < len; i++)

            rs[1+i] = digits[i];

            return rs;

        }

            return digits;

    }

}
