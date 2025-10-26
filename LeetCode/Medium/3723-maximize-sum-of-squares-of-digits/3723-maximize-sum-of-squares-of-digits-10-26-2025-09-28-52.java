class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(checkInValid(num,sum)){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<num;i++){
            int min = Math.min(9,sum);
            ans.append(min);
            sum -= min;
        }
        return sum==0 ? ans.toString():"";
    }
    private boolean checkInValid(int n , int s){
        return s<0 || s>9*n;
    }
}