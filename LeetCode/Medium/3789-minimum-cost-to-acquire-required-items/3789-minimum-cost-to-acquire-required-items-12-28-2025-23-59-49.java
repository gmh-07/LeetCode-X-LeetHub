class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int minNeed = Math.min(need1,need2);
        int maxNeed = Math.max(need1,need2);

        long ans = 0;
        if(costBoth < cost1+cost2){
            ans = (long)minNeed * costBoth;
            if(maxNeed == need1){
                if(costBoth < cost1){
                    ans += (long)(maxNeed - minNeed)*costBoth;
                }
                else{
                    ans += (long)(maxNeed - minNeed)*cost1;
                }
            }
            else if(maxNeed == need2){
                if(costBoth < cost2){
                    ans += (long)(maxNeed - minNeed)*costBoth;
                }
                else{
                    ans += (long)(maxNeed - minNeed)*cost2;
                }
            }
        }
        else{
            ans = (long)need1*cost1 + (long)need2*cost2;
        }
        return ans;
    }
}