class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int originalNum = nums.get(i);
            int res = -1;
            for(int j=1;j<originalNum;j++){
                if((j | (j+1)) == originalNum){
                    res = j;
                    break;
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}