class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int len = 1;
                int temp = num;
                while(set.contains(temp+1)){
                    len++;
                    temp++;
                }
                maxLen = Math.max(maxLen,len);
            }
        }
        
        return maxLen;
    }
}




// First Approach:
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         int n = nums.length;
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             set.add(nums[i]);
//             max = Math.max(max,nums[i]);
//             min = Math.min(min,nums[i]);
//         }
//         int len = 0;
//         int maxLen = 0;
//         for(int i=min;i<=max;i++){
//             if(set.contains(i)){
//                 len++;
//             }
//             else len = 0;
//             maxLen = Math.max(maxLen,len);
//         }
        
//         return maxLen;
//     }
// }