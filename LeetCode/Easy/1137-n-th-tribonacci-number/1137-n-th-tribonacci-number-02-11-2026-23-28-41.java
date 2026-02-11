class Solution {
    private int helper(int[] dp , int n){
        if(n<=1) return n;
        if(n==2) return 1;
        if(dp[n] != -1) return dp[n];
        int ans = helper(dp,n-1)+helper(dp,n-2)+helper(dp,n-3);
        return dp[n] = ans;
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }
}