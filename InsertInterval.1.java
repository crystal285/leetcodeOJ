/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 //first version, traditional
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> lists = new ArrayList<>();
        int pos = 0;
        for(Interval t : intervals)
        {
            if(t.end < newInterval.start)
            {
                lists.add(t);
                pos++;
            }
            else if(newInterval.end < t.start)
            {
                lists.add(t);
            }
            else
            {
                newInterval.start = Math.min(t.start,newInterval.start);
                newInterval.end = Math.max(t.end, newInterval.end);
            }
        }
        lists.add(pos, newInterval);
        return lists;
    }
}