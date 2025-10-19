class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n =nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
            
        }
        int count = k;
        while(true){
            if(!set.contains(count)){
                return count;
            }
            count = count + k;
        }
    }
}