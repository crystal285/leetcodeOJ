//a smart solution, pay attention to the use of isNumeric
public class Solution {

    public boolean isNumber(String s) {

        int i = 0, j = s.length();

        boolean isNumeric = false;

        while(i < j && s.charAt(i) == ' ')

            i++;

        if(i < j && (s.charAt(i) == '+' || s.charAt(i) == '-'))

            i++;

        while(i < j && Character.isDigit(s.charAt(i)))

            {

            i++;

            isNumeric = true;

            }

        if(i < j && s.charAt(i) == '.')

            {

                i++;

                while(i < j && Character.isDigit(s.charAt(i)))

                {

                    i++;

                    isNumeric = true;

                }

            }

        if(isNumeric && i < j && s.charAt(i) == 'e')

        {

            i++;

            isNumeric = false;

             if(i < j && (s.charAt(i) == '+' || s.charAt(i) == '-'))

                i++;

            while(i < j &&Character.isDigit(s.charAt(i)))

                {

                    i++;

                    isNumeric = true;

                }

        }

        while(i < j && s.charAt(i) == ' ')

            i++;

        if(isNumeric && i == j)

            return true;

        else

            return false;

    }

}
