class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1) return 0;
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = nums[k-1]-nums[0];
        for(int i=k;i<n;i++){
            int diff = nums[i]-nums[i-k+1];
            minDiff = Math.min(minDiff,diff);
        }
        return minDiff;
    }
}