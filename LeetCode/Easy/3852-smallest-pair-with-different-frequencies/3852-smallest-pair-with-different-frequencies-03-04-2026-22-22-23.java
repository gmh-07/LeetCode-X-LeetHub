// Optimized Approach
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) 
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        int d = freq.size();
        int[] vals = new int[d];
        int idx = 0;
        for (int v : freq.keySet()) 
            vals[idx++] = v;
        Arrays.sort(vals);

        for (int i = 0; i < d; i++) {
            int x = vals[i];
            for (int j = i + 1; j < d; j++) {
                int y = vals[j];
                if (freq.get(x) != freq.get(y)) 
                    return new int[]{x, y};
            }
        }
        return new int[]{-1, -1};
    }
}



/*
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(map);
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        Arrays.sort(nums);

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    if(map.get(nums[i]) != map.get(nums[j])){
                        ans[0] = nums[i];
                        ans[1] = nums[j];
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
}
*/