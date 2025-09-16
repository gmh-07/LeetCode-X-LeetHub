class Solution {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            min = Math.min(min,Math.abs(nums[i]-nums[i+1]));
        }
        return min;
    }
}