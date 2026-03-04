class Solution {
    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int count = 0;
        for(int i=0;i<r;i++){
            int sum = 0;
            int idx = -1;
            // System.out.println("row no : "+i);
            for(int j=0;j<c;j++){
                if(mat[i][j]==1){
                    sum += 1;
                    idx = j;
                }
            }
            // System.out.println("idx no : "+idx);
            // System.out.println("row Sum  : "+sum);
            if(sum == 1){
                int colSum = 0;
                for(int k=0;k<r;k++){
                    // System.out.println("current col sum : "+colSum);
                    // System.out.println("i : "+i + " j : "+idx);
                    colSum += mat[k][idx];
                }
                if(colSum==1) count++;
                // System.out.println("col sum : "+colSum);
            }
        }
        return count;
    }
}