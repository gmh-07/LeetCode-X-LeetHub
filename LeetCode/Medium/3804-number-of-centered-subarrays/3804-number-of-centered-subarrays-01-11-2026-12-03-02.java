class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int count = 0;
        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums[j]);
                int sum = prefixSum[j];
                if(j>0){
                    sum = prefixSum[j]-prefixSum[j-1];
                }
                if(set.contains(sum)) count++;
            }
        }
        return count-1;
    }
}