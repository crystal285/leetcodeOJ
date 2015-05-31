import java.util.*;
public class ConcantentationsOfStirngs
{
	static String[] dic = {"world","hello","super","hell"};
	public boolean isValid(String key)
	{
		HashSet<String> set = new HashSet<String>();
		for(String s : dic)
			set.add(s);
		int n = key.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		for(int i = 1; i < n+1; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(dp[j] && set.contains(key.substring(j,i)))
					{
						dp[i] = true;
						break;
					}
			}
		}
		return dp[n];
	}
}