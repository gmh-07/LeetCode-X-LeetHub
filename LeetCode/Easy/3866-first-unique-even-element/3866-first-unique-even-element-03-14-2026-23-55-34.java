class Solution {
    public int firstUniqueEven(int[] nums) {
        int n = nums.length;
        int ans = -1;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(flag) break;
            if(nums[i]%2==0){
                flag = true;
                for(int j=0;j<n;j++){
                    if(i==j) continue;
                    if(nums[j]==nums[i]){
                        flag = false;
                        break;
                    }
                }
                if(flag) ans = nums[i];
            }
        }
        return ans;
    }
}