class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int[] avgArr = new int[n];
        int count = 1;
        int sum = 0;
        for(int i=n-1;i>0;i--){
            sum += nums[i];
            avgArr[i] = sum/count;
            count++;
        }
        avgArr[0] = nums[0];
        int ans = 0;
        for(int i=0;i<n-1;i++){
            if(nums[i]>avgArr[i+1]) ans++;
        }
        return ans;
    }
}