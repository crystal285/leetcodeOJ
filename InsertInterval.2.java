/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 //more tricky and concise version
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> lists = new ArrayList<Interval>();
        for(Interval t: intervals)
        {
            if(t.end < newInterval.start)
            {
                lists.add(t);
            }
            else if(newInterval.end < t.start)
            {
                lists.add(newInterval);
                newInterval = t;
            }
            else if(newInterval.end >= t.start)
            {
                newInterval.start = Math.min(t.start, newInterval.start);
                newInterval.end = Math.max(newInterval.end, t.end);
            }
        }
        lists.add(newInterval);
        return lists;
    }
}