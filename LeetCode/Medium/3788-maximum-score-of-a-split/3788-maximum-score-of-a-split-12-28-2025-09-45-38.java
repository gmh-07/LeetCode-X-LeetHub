class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = (long)nums[i]+prefixSum[i-1];
        }
        int[] suffixMin = new int[n];
        suffixMin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMin[i] = Math.min(suffixMin[i+1],nums[i]);
        }
        long max = Long.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            int currMin = suffixMin[i+1];
            max = Math.max(max,prefixSum[i]-currMin);
        }
        return max;
    }
}