class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){

            if(i>0 && nums[i-1]==nums[i]) continue;


            int target = -nums[i];
            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = nums[left]+nums[right];
                if(sum == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(right>0 && nums[right] == nums[right-1]) right--;
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                    right--;
                }
                else if(sum < target) left++;
                else right--;
            }
        }
        return ans;
    }
}