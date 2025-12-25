class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long ans = 0;
        int curr = 0;
        for(int i=n-1;i>=0;i--){
            int adder = happiness[i]-curr;
            if(adder<=0 || k==0) break;
            ans += adder;
            curr++;
            k--;
        }
        return ans;
    }
}