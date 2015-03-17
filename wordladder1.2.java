//using a queue to record the depth
 class Solution {

    public int ladderLength(String start, String end, HashSet<String> dict) {

        if(start.equals(end))

            return 1;

        LinkedList<String> queue = new LinkedList<String>();

        LinkedList<Integer> len = new LinkedList<Integer>();

        len.add(1);

        queue.add(start);

        while(queue.size() > 0)

        {

            String str = queue.poll();

            int length = len.poll() + 1;

            for(int i = 0; i < start.length(); i++)

            {

                char[] array = str.toCharArray();

                for(char c = 'a'; c <= 'z'; c++)

                {

                    if(array[i] != c)

                    {

                        array[i] = c;

                        String s = String.valueOf(array);

                        if(s.equals(end))

                            return length;

                        if(dict.contains(s))

                        {

                            queue.add(s);

                            len.add(length);

                            dict.remove(s);

                        }

                    }

                }

            }

        }

        return 0;

    }

}
