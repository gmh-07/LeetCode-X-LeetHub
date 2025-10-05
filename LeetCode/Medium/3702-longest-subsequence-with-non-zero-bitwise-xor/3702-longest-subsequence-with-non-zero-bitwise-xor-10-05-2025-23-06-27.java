class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean allZero = true;
        for(int num:nums){
            if(num != 0){
                allZero = false;
                break;
            }
        }
        if(allZero) return 0;
        int xorSum = 0;
        for(int num:nums){
            xorSum ^= num;
        }
        if(xorSum==0) return n-1;
        return n;
    }
}