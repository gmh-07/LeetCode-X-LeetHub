class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int ts = 0;
        for(int i=0;i<n;i++){
            if(map.get(nums[i]) % k == 0) ts += nums[i];
        }
        return ts;
    }
}