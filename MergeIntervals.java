/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new mycomparator());
        int i = 0;
        while(i < intervals.size()-1) //pay attention to for loop, index change when remove
        {
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i+1);
            if(next.start <= cur.end)
            {
                cur.end = Math.max(cur.end,next.end);
                intervals.remove(i+1);
            }
            else
                i++;
        }
        return intervals;
    }
    class mycomparator implements Comparator<Interval>
    {
        public int compare(Interval t1, Interval t2)
        {
            return t1.start - t2.start;
        }
    }
}