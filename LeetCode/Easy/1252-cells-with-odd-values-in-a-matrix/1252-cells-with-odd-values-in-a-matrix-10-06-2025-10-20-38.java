class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int len = indices.length;
        for(int[] row:indices){
            int r = row[0];
            int c = row[1];
            for(int i=0;i<n;i++){
                matrix[r][i]++;
            }
            for(int i=0;i<m;i++){
                matrix[i][c]++;
            }
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] % 2==1) count++;
            }
        }
        return count;
    }
}