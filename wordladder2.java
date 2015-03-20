//more space efficient, first perform bfs until meeting the end point, then set the level to be the final level. Then from end point do dfs.
 class Solution {

    public static List<List<String>> findLadders(String start, String end, HashSet<String> dict) {

        List<List<String>> lists = new LinkedList<List<String>>();

        if(start.equals(end))

        {

            List<String> list = new LinkedList<String>();

            list.add(start);

            lists.add(list);

            return lists;

        }

        dict.add(start);

        dict.add(end);

        HashMap<String,List<String>> parent = new HashMap<String,List<String>>();//store all the parent nodes of the node String

        //List<String> list = new LinkedList<String>();

        bfs(start,end,dict,parent);

        if(!parent.containsKey(end))  // if not find a shortest path

        {

            return lists;

        }

        List<String> path = new LinkedList<String>();

        path.add(end);

        dfs(start,end,parent,path,lists);

        return lists;

    }

    

public static void dfs(String start, String cur, HashMap<String,List<String>> parent, List<String> path,List<List<String>> lists)

{

    if(cur.equals(start))

    {

        Collections.reverse(path);

        lists.add(new LinkedList(path));

        Collections.reverse(path);

    }

    else

    {

    //System.out.println(cur);

    for(String s : parent.get(cur))

    {

        path.add(s);

        dfs(start,s,parent,path,lists);

        path.remove(path.size()-1);

    }

    }

}



public static void bfs(String start, String end, HashSet<String> dict, HashMap<String,List<String>> map)

{

    HashMap<String,Integer> distance = new HashMap<String,Integer>();// store the depth of each string

    List<String> current = new LinkedList<String>(); //level-order 

    List<String> parent = null;

    current.add(start);

    distance.put(start,0);

    boolean finallevel = false;

    while(!current.isEmpty())

    {

        if(finallevel)

            break;

        else

        {

            parent = current;

            current = new LinkedList<String>();

            for(String s : parent)

            {

                 int level = distance.get(s);

            for(int i = 0; i < s.length(); i++)

            {

                char[] array = s.toCharArray();

                for(char c = 'a'; c <= 'z'; c++)

                {

                	if(c != s.charAt(i))  // not c!=array[i]

                    {

                        array[i] = c;

                        String str = String.valueOf(array);

                            //System.out.println(str);

                        if(dict.contains(str) && !str.equals(start))//pay attention to !str.equals(start) since start is not in the map

                        {

                            if(!map.containsKey(str))

                            {

                            	 //System.out.println(str+","+map.containsKey(str)+" "+s);

                                List<String> list = new LinkedList<String>();

                                list.add(s);

                                map.put(str,list);

                                current.add(str);

                                distance.put(str,level+1);

                            }

                            else

                            {

                                String temp = map.get(str).get(0);

                                if(distance.get(temp) == level)// all the previous nodes must be in the same level.If not, there will be a loop

                                {

                                map.get(str).add(s);

                                //System.out.println(str+","+map.containsKey(str)+" "+s);

                                }

                            }





                            if(str.equals(end))  //if meet the end,then set the level to be the final level



                            {



                                finallevel = true;



                            }



                        }



                    }



                }







            }



            }



        }



    }

}

}
