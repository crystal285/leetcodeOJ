1.	class LinkedHashEntry 
2.	{
3.	    String key;
4.	    int value;
5.	    LinkedHashEntry next;
6.	 
7.	    /* Constructor */
8.	    LinkedHashEntry(String key, int value) 
9.	    {
10.	        this.key = key;
11.	        this.value = value;
12.	        this.next = null;
13.	    }
14.	}
15.	 
16.	/* Class HashTable */
17.	class HashTable
18.	{
19.	    private int TABLE_SIZE;
20.	    private int size; 
21.	    private LinkedHashEntry[] table;
22.	 
23.	     /* Constructor */
24.	    public HashTable(int ts) 
25.	    {
26.	        size = 0;
27.	        TABLE_SIZE = ts;
28.	        table = new LinkedHashEntry[TABLE_SIZE];
29.	        for (int i = 0; i < TABLE_SIZE; i++)
30.	            table[i] = null;
31.	    } 
32.	    /* Function to get number of key-value pairs */
33.	    public int getSize()
34.	    {
35.	        return size;
36.	    }
37.	    /* Function to clear hash table */
38.	    public void makeEmpty()
39.	    {
40.	        for (int i = 0; i < TABLE_SIZE; i++)
41.	            table[i] = null;
42.	    }
43.	    /* Function to get value of a key */
44.	    public int get(String key) 
45.	    {
46.	        int hash = myhash( key );
47.	        if (table[hash] == null)
48.	            return -1;
49.	        else 
50.	        {
51.	            LinkedHashEntry entry = table[hash];
52.	            while (entry != null && !entry.key.equals(key))
53.	                entry = entry.next;
54.	            if (entry == null)
55.	                return -1;
56.	            else
57.	                return entry.value;
58.	        }
59.	    }
60.	    /* Function to insert a key value pair */
61.	    public void insert(String key, int value) 
62.	    {
63.	        int hash = myhash( key );
64.	        if (table[hash] == null)
65.	            table[hash] = new LinkedHashEntry(key, value);
66.	        else 
67.	        {
68.	            LinkedHashEntry entry = table[hash];
69.	            while (entry.next != null && !entry.key.equals(key))
70.	                entry = entry.next;
71.	            if (entry.key.equals(key))
72.	                entry.value = value;
73.	            else
74.	                entry.next = new LinkedHashEntry(key, value);
75.	        }
76.	        size++;
77.	    }
78.	 
79.	    public void remove(String key) 
80.	    {
81.	        int hash = myhash( key );
82.	        if (table[hash] != null) 
83.	        {
84.	            LinkedHashEntry prevEntry = null;
85.	            LinkedHashEntry entry = table[hash];
86.	            while (entry.next != null && !entry.key.equals(key)) 
87.	            {
88.	                prevEntry = entry;
89.	                entry = entry.next;
90.	            }
91.	            if (entry.key.equals(key)) 
92.	            {
93.	                if (prevEntry == null)
94.	                    table[hash] = entry.next;
95.	                else
96.	                    prevEntry.next = entry.next;
97.	                size--;
98.	            }
99.	        }
100.	    }
101.	    /* Function myhash which gives a hash value for a given string */
102.	    private int myhash(String s)
103.		{
104.			int hash = 0;
105.			for(int i = 0; i < s.length();i++)
106.				hash = (31*hash + s.charAt(i)) % TableSize;
107.		}
108.	    /* Function to print hash table */
109.	    public void printHashTable()
110.	    {
111.	        for (int i = 0; i < TABLE_SIZE; i++)
112.	        {
113.	            System.out.print("\nBucket "+ (i + 1) +" : ");
114.	            LinkedHashEntry entry = table[i];
115.	            while (entry != null)
116.	            {
117.	                System.out.print(entry.value +" ");
118.	                entry = entry.next;
119.	            }            
120.	        }
121.	    }
122.	}
123.	 
124.	/* Class HashTablesChainingListHeadsTest */
125.	public class HashTablesChainingListHeadsTest
126.	{
127.	    public static void main(String[] args)
128.	    {
129.	        Scanner scan = new Scanner(System.in);
130.	        System.out.println("Hash Table Test\n\n");
131.	        System.out.println("Enter size");
132.	        /* Make object of HashTable */
133.	        HashTable ht = new HashTable(scan.nextInt() );
134.	 
135.	        char ch;
136.	        /*  Perform HashTable operations  */
137.	        do    
138.	        {
139.	            System.out.println("\nHash Table Operations\n");
140.	            System.out.println("1. insert ");
141.	            System.out.println("2. remove");
142.	            System.out.println("3. get");            
143.	            System.out.println("4. clear");
144.	            System.out.println("5. size");
145.	 
146.	            int choice = scan.nextInt();            
147.	            switch (choice)
148.	            {
149.	            case 1 : 
150.	                System.out.println("Enter key and value");
151.	                ht.insert(scan.next(), scan.nextInt() ); 
152.	                break;                          
153.	            case 2 :                 
154.	                System.out.println("Enter key");
155.	                ht.remove( scan.next() ); 
156.	                break;                        
157.	            case 3 : 
158.	                System.out.println("Enter key");
159.	                System.out.println("Value = "+ ht.get( scan.next() )); 
160.	                break;                                   
161.	            case 4 : 
162.	                ht.makeEmpty();
163.	                System.out.println("Hash Table Cleared\n");
164.	                break;
165.	            case 5 : 
166.	                System.out.println("Size = "+ ht.getSize() );
167.	                break;         
168.	            default : 
169.	                System.out.println("Wrong Entry \n ");
170.	                break;   
171.	            }
172.	            /* Display hash table */
173.	            ht.printHashTable();  
174.	 
175.	            System.out.println("\nDo you want to continue (Type y or n) \n");
176.	            ch = scan.next().charAt(0);                        
177.	        } while (ch == 'Y'|| ch == 'y');  
178.	    }
179.	}

