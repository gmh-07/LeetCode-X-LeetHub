class Solution {
    public int scoreDifference(int[] nums) {
        boolean firstActive = true;
        int first = 0;
        int second = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                firstActive = !firstActive;
            }
            if(i%6==5){
                firstActive = !firstActive;
            }
            if(firstActive){
                first += nums[i];
                System.out.println("f : " + first);
            }
            else{
                second += nums[i];
                System.out.println("s : " + second);
            }
        }
        return first - second;
    }
}