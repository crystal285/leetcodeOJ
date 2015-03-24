// Newton's method
public class Solution {

    public int sqrt(int x) {

        if(x == 0)

            return 0;

        double last = 0;

        double rs = x;

        while(last != rs)

        {

            last = rs;

            rs = (rs + x/rs)/2;

        }

        return (int)rs;

    }

}
