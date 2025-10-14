class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i=0;i<=n-2*k;i++){
            boolean firstArray=true,secondArray=true;
            for(int j=i+1;j<k+i;j++){
                if(nums.get(j-1) >= nums.get(j)){
                    firstArray = false;
                }
            }
            for(int j=i+k+1;j<k+k+i;j++){
                if(nums.get(j-1) >= nums.get(j)){
                    secondArray = false;
                }
            }
            if((firstArray && secondArray)==true){
                return true;
            }
        }
        return false;
    }
}