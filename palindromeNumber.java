public class Solution {

    public boolean isPalindrome(int x) {

        if(x < 0)

            return false;

        int div = 1;

        while(x / div >= 10)

            div *= 10;

        int head = 0, end = 0;

        while(x != 0)

        {

            head = x / div;

            end = x % 10; //pay attentio to the order of the statement to deal with the number during 0-9

            if(head != end)

                return false;

            x = x % div/10;

            div /= 100;

        }

        return true;

    }

}
