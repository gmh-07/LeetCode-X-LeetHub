class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p = -1;
        int q = -1;
        boolean flag = false;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1] && !flag){
                p = i;
            }
            else if(nums[i]<nums[i-1]){
                flag = true;
                q = i;
            }
            else{
                break;
            }
        }
        System.out.println("p :"+p);
        System.out.println("q :"+q);

        if(p==-1 || q==-1 || q==n-1) return false; 

        for(int i=q+1;i<n;i++){
            if(nums[i]<=nums[i-1]) return false;
        }
        return true;
    }
}