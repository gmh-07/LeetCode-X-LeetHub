class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i=n-1;i>=1;i--){
            int j = i-1;
            if(nums[j]<nums[i]){
                int temp = nums[j]+1;
                int getIdx = -1;
                // int min 
                for(int k=i;k<n;k++){
                    if(nums[k]>nums[j]){
                        getIdx = k;
                    }
                }
                
                swap(nums,j,getIdx);

                reverse(nums,i,n-1);

                break;
            }
            else if(j==0){
                reverse(nums,0,n-1);
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    private void swap(int[] nums,int j,int getIdx){
        int temp1 = nums[getIdx];
        nums[getIdx] = nums[j];
        nums[j] = temp1;
    }
    private void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}