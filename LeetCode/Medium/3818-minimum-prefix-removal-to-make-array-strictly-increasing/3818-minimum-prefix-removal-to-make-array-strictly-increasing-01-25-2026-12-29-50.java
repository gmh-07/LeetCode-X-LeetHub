class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        for(int i=n-2;i>=0;i--){
            int left = nums[i];
            int right = nums[i+1];
            if(left >= right){
                return i+1;
            }
        }
        return 0;
    }
}