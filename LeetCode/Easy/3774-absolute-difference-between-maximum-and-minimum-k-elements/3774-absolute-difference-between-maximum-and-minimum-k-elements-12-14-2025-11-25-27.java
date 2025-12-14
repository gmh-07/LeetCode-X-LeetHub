class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int large = 0;
        int small = 0;
        for(int i=0;i<k;i++){
            large += nums[i];
        }
        for(int i=n-1;i>=n-k;i--){
            small += nums[i];
        }
        return small-large;
    }
}