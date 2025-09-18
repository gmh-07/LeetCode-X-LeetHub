class Solution {
    public int maxSum(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int r = grid.length;
        int c = grid[0].length;
        for(int i=0;i<=r-3;i++){
            for(int j=0;j<=c-3;j++){
                int sum = 0;
                for(int a=i;a<i+3;a++){
                    for(int b=j;b<j+3;b++){
                        if((a-i==1 && b-j==0)||(a-i==1 && b-j==2)) continue;
                        sum += grid[a][b];
                    }
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}