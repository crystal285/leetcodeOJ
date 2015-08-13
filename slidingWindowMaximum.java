 public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<Integer>();
        if(nums.length == 0 || nums == null || k == 0)
            return new int[0];
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++)
        {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
            {
                    deque.pollLast();
                }
            deque.add(i);
            if(i >= deque.peekFirst()+k)
                deque.pollFirst();
            if(i >= k-1)
                ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}