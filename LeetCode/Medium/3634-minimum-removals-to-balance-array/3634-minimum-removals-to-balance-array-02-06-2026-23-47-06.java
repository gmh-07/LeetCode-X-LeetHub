class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return 0;
        Arrays.sort(nums);
        int count = Integer.MAX_VALUE;
        int low = 0;
        
        for(int high=0;high<n;high++){
            int max = nums[high];
            while(max > (long)nums[low]*k) low++;
            count = Math.min(count,n-(high-low+1));
        }

        return count;
    }
}