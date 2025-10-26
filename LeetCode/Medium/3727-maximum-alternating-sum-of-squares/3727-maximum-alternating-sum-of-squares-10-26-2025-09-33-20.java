class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long tsq = 0L;
        long[] sq = new long[n];
        
        for(int i=0;i<n;i++){
            sq[i] = 1L * nums[i] * nums[i];
            tsq += sq[i];
        }
        int elementsToPick = (n+1)/2;
        Arrays.sort(sq);
        long sum = 0L;
        
        for(int idx=n-elementsToPick;idx<n;idx++){
            sum += sq[idx];
        }
        return (2*sum)-tsq;
    }
}