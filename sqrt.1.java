//simple binary search
 class Solution {

    public int sqrt(int x) {

        if(x <= 1)

            return x;

        long low = 1;

        long high = x;

        long mid;

        long square;

        while(low +1 < high)

        {

            mid = (low+high)/2;

            square = mid*mid;

            if(square == x)

                return (int)mid;

            if(square < x)

            {

                low = mid;

            }

            if(square > x)

                high = mid;

        }

        return (int)low;

    }

}
