class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return helper(triangle,0,0,dp);
    }
    private int helper(List<List<Integer>> triangle,int r,int c,Integer[][] dp){
        int n = triangle.size();
        if(r==n-1) return triangle.get(r).get(c);
        if(dp[r][c] != null) return dp[r][c];
        int minSum = triangle.get(r).get(c) + Math.min(helper(triangle,r+1,c,dp),helper(triangle,r+1,c+1,dp));
        return dp[r][c] = minSum;
    }
}




/*

This version is good ✅ — you’ve fixed the earlier “0 sentinel” bug by pre-filling your dp array with -1.

Here’s why this works now:

You initialize every cell of dp to -1:

for (int[] row : dp) Arrays.fill(row, -1);


You only treat dp[r][c] != -1 as “already computed.”

Your path sums (because of the triangle’s constraints on LeetCode) are never negative (LeetCode’s Triangle problem guarantees each number is between -10^4 and 10^4 though).

⚠️ One caveat: if the triangle could contain negative values, then the true minimum sum might be -1 and you’d get a false “already computed.”

If your triangle input can have negatives, you should instead:

Use Integer[][] dp with null as “not computed,” or

Fill dp with something impossible, e.g. Integer.MAX_VALUE.

*/
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
//         return helper(triangle,0,0,dp);
//     }
//     private int helper(List<List<Integer>> triangle,int r,int c,int[][] dp){
//         int n = triangle.size();
//         if(r==n-1) return triangle.get(r).get(c);
//         if(dp[r][c] != -1) return dp[r][c];
//         int minSum = triangle.get(r).get(c) + Math.min(helper(triangle,r+1,c,dp),helper(triangle,r+1,c+1,dp));
//         return dp[r][c] = minSum;
//     }
// }