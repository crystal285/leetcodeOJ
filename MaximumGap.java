//Suppose there are N elements and they range from A to B.Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)].N-1 gaps. Let the length of a bucket (interval)to be interval = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / interval + 1 of bucket.for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / interval and therefore maintain the maximum and minimum elements in each bucket.Since the maximum difference between elements in the same buckets will be at most interval - 1, so the final answer will not be taken from two elements in the same buckets.
public class Solution {
    
    class Bucket
    {
        int min;
        int max;
        public Bucket(int min, int max)
        {
            this.min = min;
            this.max = max;
        }
    }
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int high = nums[0];
        int low = nums[0];//pay attention, not 0
        for(int num : nums)
        {
            high = Math.max(num,high);
            low = Math.min(num,low);
        }
        int interval = (int) Math.ceil((double)(high-low)/(n-1));//pay attention, interval must > 0
        int blen = (high-low)/interval + 1;
        Bucket[] buckets = new Bucket[blen];
        for(int num : nums)
        {
            int index = (num-low)/interval;
            if(buckets[index] == null)
            {
                buckets[index] = new Bucket(num,num);
            }
            else
            {
                buckets[index].max = Math.max(num,buckets[index].max);
                buckets[index].min = Math.min(num,buckets[index].min);
            }
        }
        int gap = 0;
        int pre = low;
        for(int i = 0; i < blen; i++)
        {
            if(buckets[i] != null)//pay attention to bucket could be null
            {
                gap = Math.max(gap,buckets[i].min - pre);
                pre = buckets[i].max;
            }
        }
        return gap;
    }
}