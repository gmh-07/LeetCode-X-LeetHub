class Solution {
    public int countCoprime(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int limit = 1000000007;

        int highest = 0;
        for(int[] arr:mat){
            for(int num:arr){
                if(num > highest) highest = num;
            }
        }
        long[][] ways = new long[n+1][highest+1];
        ways[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int g =0;g<=highest;g++){
                if(ways[i][g]==0) continue;
                for(int j=0;j<m;j++){
                    int nextGcd = gcd(g,mat[i][j]);
                    ways[i+1][nextGcd] = (ways[i+1][nextGcd]+ways[i][g])%limit;
                }
            }
        }
        return (int)ways[n][1];
    }
    private int gcd(int a,int b){
        while(b !=0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
}