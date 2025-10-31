class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int idx = 0;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(idx == 2) return ans;
            if(nums[i-1]==nums[i]){
                ans[idx] = nums[i];
                idx++;
            }
        }
        return ans;
    }
}