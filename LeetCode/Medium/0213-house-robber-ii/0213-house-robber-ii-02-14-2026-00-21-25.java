class Solution {
    private int maxAmountFn1(int[] nums,int i,int[] dp){
        int n = nums.length;
        if(i>=n) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + maxAmountFn1(nums,i+2,dp);
        int skip = maxAmountFn1(nums,i+1,dp);
        return dp[i] = Math.max(take,skip);
    }
    private int maxAmountFn2(int[] nums,int i,int[] dp){
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + maxAmountFn2(nums,i-2,dp);
        int skip = maxAmountFn2(nums,i-1,dp);
        return dp[i] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int a = maxAmountFn1(nums,1,dp);
        Arrays.fill(dp,-1);
        int b = maxAmountFn2(nums,n-2,dp);
        return Math.max(a,b);
    }
}




// //Recursive Approach:
// class Solution {
//     private int maxAmountFn1(int[] nums,int i){
//         int n = nums.length;
//         if(i>=n) return 0;
//         int take = nums[i] + maxAmountFn1(nums,i+2);
//         int skip = maxAmountFn1(nums,i+1);
//         return Math.max(take,skip);
//     }
//     private int maxAmountFn2(int[] nums,int i){
//         if(i<0) return 0;
//         int take = nums[i] + maxAmountFn2(nums,i-2);
//         int skip = maxAmountFn2(nums,i-1);
//         return Math.max(take,skip);
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n==1) return nums[0];
//         int a = maxAmountFn1(nums,1);
//         int b = maxAmountFn2(nums,n-2);
//         return Math.max(a,b);
//     }
// }