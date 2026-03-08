class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(nums[i],2);
            set.add(num);
        }
        // System.out.println(set);
        int decimalNum = -1;
        for(int i=0;i<Math.pow(2,n);i++){
            if(!set.contains(i)){
                decimalNum = i;
                break;
            }
        }
        String ans = Integer.toBinaryString(decimalNum);
        if(ans.length() != n){
            while(ans.length() != n){
                ans = "0"+ans;
            }
        }
        return ans;
    }
}