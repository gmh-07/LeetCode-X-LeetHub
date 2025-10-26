class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long[] preSum = new long[n+1];
        for(int i=0;i<n;i++){
            preSum[i+1] = preSum[i]+capacity[i];
        }

        HashMap<String,Long> sub = new HashMap<>();
        long stableCnt = 0;
        for(int j=0;j<n;j++){
            if(j>=2){
                int i=j-2;
                long fe = capacity[i];
                long kv = preSum[i]+3L*fe;
                String key = fe+","+kv;
                sub.put(key,sub.getOrDefault(key,0L)+1);
            }
            String qk = capacity[j]+","+preSum[j+1];
            stableCnt += sub.getOrDefault(qk,0L);
        }
        return stableCnt;
    }
}