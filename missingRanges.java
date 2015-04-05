
public class Solution {

    public List<String> findMissingRanges(int[] A, int lower, int upper) {

    List<String> list = new ArrayList<String>();

    int pre = lower-1;

    int cur = 0;

    for(int i = 0; i <= A.length; i++)

    {

        if(i == A.length)

            cur = upper+1;

        else

            cur = A[i];

        if(cur - pre >= 2)

            list.add(find(A,pre+1,cur-1));

        pre = cur;

    }

    return list;

    }

    public String find(int[] A, int pre, int cur)

    {

        if(pre == cur)

            return String.valueOf(pre);

        else

            return pre+"->"+cur;

    }

}
