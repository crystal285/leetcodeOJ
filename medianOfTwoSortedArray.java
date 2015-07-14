//using find kth smallest element idea
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 0)
            return (findKth(nums1, nums2, 0, 0, len/2) + findKth(nums1, nums2, 0, 0, len/2+1)) / 2.0;
        else
            return findKth(nums1, nums2, 0, 0, len/2+1);
    }
    
    public int findKth(int[] num1, int[] num2, int start1, int start2, int k)
    {
        int m = num1.length;
        int n = num2.length;
        if(start1 >= m) //attention1
            return num2[start2 + k - 1];
        if(start2 >= n)
            return num1[start1 + k - 1];
        if(k == 1) //base case
            return Math.min(num1[start1], num2[start2]);
        int val1 = Integer.MAX_VALUE;
        int val2 = Integer.MAX_VALUE;
        if(start1 + k/2 -1 < m) // attention2
            val1 = num1[start1 + k/2 - 1];
        if(start2 + k/2 - 1 < n)
            val2 = num2[start2 + k/2 - 1];
        if(val1 <= val2) //discard left part of num1 and right part of num2
            return findKth(num1, num2,start1 + k/2, start2, k-k/2);
        else
            return findKth(num1, num2, start1, start2 + k/2, k - k/2);
    }
}