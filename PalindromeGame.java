import java.io.*;
import java.util.*;
class test {
    public static void main(String [] args) throws Exception{
        BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
        String front = in.readLine();
        List<String>  frontlist= Arrays.asList(front.split(","));
        String back = in.readLine();
        List<String>  backlist= Arrays.asList(back.split(","));
       int rs = getMaximum(frontlist,backlist);
        System.out.println(rs);
    }
  public static int getMaximum(List<String> front, List<String> back)
  {
    int res=0;
    int n = front.size();
    boolean[] use=new boolean[n];
    boolean find=false;
    while(true){
      find=false;
      int max=0,a,b;
      a=b=-1;
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          if(i!=j && !use[i] && !use[j] && isPalindrome(front.get(i), front.get(j))){

            find=true;
             int b1 = Integer.parseInt(back.get(i));
             int b2 = Integer.parseInt(back.get(j));
            if((b1+b2)>max){
              max=b1+b2;
              a=i;
              b=j;
            }

          }
        }
      }
      if(!find)
        break;
      use[a]=true;
      use[b]=true;
      res+=max;
    }
    int max=0;
    for(int i=0;i<n;i++){
      if(!use[i] && isPalindrome(front.get(i)))
        max=Math.max(max, Integer.parseInt(back.get(i)));
    }
    res+=max;
    return res;
  }
    public static boolean isPalindrome(String s){
    int i=0;
    int j=s.length()-1;
    while(i<j){
      if(s.charAt(i)!=s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

  public static boolean isPalindrome(String s1,String s2){
    int n = s1.length();
    int i = 0;
    while(i<n){
      if(s1.charAt(i)!=s2.charAt(n-1-i))
        return false;
      i++;
    }
    return true;
  }
}