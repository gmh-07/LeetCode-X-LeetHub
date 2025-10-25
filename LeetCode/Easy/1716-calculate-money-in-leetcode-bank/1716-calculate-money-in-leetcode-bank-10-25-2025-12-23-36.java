class Solution {
    public int totalMoney(int n) {
        int div = n/7;
        int rem = n%7;
        int start = 1;
        if(div==0){
            int count = 0;
            for(int i=0;i<rem;i++){
                count += i+1;
            }
            return count;
        }
        int ans = 0;
        for(int i=0;i<div;i++){
            ans += 28 + 7 * i;
            start++;
        }

        System.out.println("ans: "+ans);
        
        if(rem != 0){
            int count = start;
            for(int i=0;i<rem-1;i++){
                count += start+i+1;
            }
            ans += count;
        }
        return ans;
    }
}