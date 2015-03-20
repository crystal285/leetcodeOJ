//dp[i] represent s.substring(0,i+1) can be word break. dp[i] is true if 1 s.substring(0,i+1) is in dict2 dp[k] is true and s.substring(k+1,i+1) is in dict. dp[i] is false if no k is found.
 class Solution {

    public boolean wordBreak(String s, HashSet<String> dict) {

        if(dict == null || dict.size() == 0)

            return false;

        boolean[] dp = new boolean[s.length()];

        dp[0] = dict.contains(s.substring(0,1));

        for(int i = 1; i < s.length(); i++)

        {

            if(dict.contains(s.substring(0,i+1)))

                    dp[i] = true;

            else

            {

            for(int j = 0; j < i; j++)

            {

                if(dp[j] && dict.contains(s.substring(j+1,i+1)))

                {

                    dp[i] = true;

                    break;

                }

            }

            

            }

        }

        return dp[s.length()-1];

    }

}
