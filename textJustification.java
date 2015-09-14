public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        if(words==null || words.length==0)  
            return list;
        int len = words.length;
        int last = 0;
        int count = 0;
        for(int i = 0; i <= len; i++)
        {
            if(i == len || count + words[i].length() + i - last > maxWidth)
            {
                StringBuffer sb = new StringBuffer();
                int spacecount = maxWidth - count;
                int interval = i-last-1;
                if(interval == 0 || i == len)
                //corner case:a line other than the last line might contain only one word: interval == 0, then left justified. i== len is the case of last line
                {
                    for(int j = last; j < i; j++)
                    {
                        sb.append(words[j]);
                        if(j != i-1)
                            sb.append(' ');
                    }
                    while(sb.length() < maxWidth)
                    {
                        sb.append(' ');
                    }
                }
                else
                //lines not the last
                {
                    int spaceExtra = spacecount % interval;
                    int spaceEach = spacecount / interval;
                    for(int j = last; j < i; j++)
                    {
                        sb.append(words[j]);
                        if(j != i-1)
                        {
                            appendspace(sb,spaceEach + (j-last < spaceExtra? 1 : 0));
                        }
                    }
                }
                list.add(sb.toString());
                last = i;
                count = 0;
            }
            if(i < len)  // pay attention
            count = count + words[i].length();
        }
        return list;
    }
    
    public void appendspace(StringBuffer sb, int count)
    {
        for(int i = 0; i < count; i++)
            sb.append(' ');
    }
}