class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long totalProfitOriginal = 0;
        for(int i=0;i<n;i++){
            totalProfitOriginal += (long)prices[i]*strategy[i];
        }
        int half = k/2;
        long gain = 0;
        for(int i=0;i<half;i++){
            gain += -(long) strategy[i]*prices[i];
        }
        for(int i=half;i<k;i++){
            gain += (1L-strategy[i])*prices[i];
        }
        long mGain = gain;
        
        for(int i=1;i+k<=n;i++){
            int j = i+k-1;
            gain -= -(long) strategy[i-1]*prices[i-1];
            gain += -(long) strategy[i+k/2-1]*prices[i+k/2-1];
            gain -= (1L-strategy[i+k/2-1]) * prices[i+k/2-1];
            gain += (1L - strategy[i+k-1])*prices[i+k-1];
            mGain = Math.max(mGain,gain);
        }
        return totalProfitOriginal+Math.max(0L,mGain);
    }
}