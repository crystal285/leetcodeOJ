/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 1)
        return points.length;
        int max = 0;
        HashMap<Double, Integer> map = null;
        for(Point p : points)
        {
            int samepoints = 0;
            map = new HashMap<Double, Integer>();
            for(Point pi : points)
            {
                if(p.x == pi.x && p.y == pi.y)
                {
                    samepoints++;
                    continue;
                }
                double slope = Double.NaN;
                if(p.x != pi.x)
                {
                    slope = 0.0 + (double)(pi.y-p.y) / (pi.x - p.x);
                }
                if(map.containsKey(slope))
                        map.put(slope,map.get(slope)+1);
                    else
                        map.put(slope,1);
            }
            int curmax = 0;
            for(Integer num : map.values())
            {
                curmax = Math.max(curmax, num);
            }
            max = Math.max(max, curmax+samepoints);
        }
        return max;
    }
}