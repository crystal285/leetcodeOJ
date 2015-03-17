//using BFS to find shortest path. 
 class Solution {

    public int ladderLength(String start, String end, HashSet<String> dict) {

        LinkedList<String> current = new LinkedList<String>();

        int len = 1;

        if(start.equals(end))

            return len;

        current.add(start);

        while(current.size() > 0)

        {

            LinkedList<String> parent = current;

            current = new LinkedList<String>();

            len++;

            for(String s : parent)

            {

            

            for(int i = 0; i < s.length(); i++)

            {

                char[] array = s.toCharArray();//initialize char[] here

                for(char c = 'a'; c <= 'z'; c++)

                {

                    if(array[i] != c)

                    {

                        array[i] = c;

                        String temps = String.valueOf(array);

                        if(temps.equals(end))

                        {

                            return len;

                        }

                        if(dict.contains(temps))

                        {

                            current.add(temps);

                            dict.remove(temps);

                        }

                    }

                }

            }

            }

        }

        return 0;

    }

}
