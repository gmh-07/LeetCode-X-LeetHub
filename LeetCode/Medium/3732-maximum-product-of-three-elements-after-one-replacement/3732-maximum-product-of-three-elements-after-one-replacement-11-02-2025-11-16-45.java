class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long a = nums[n-1];
        long b = nums[n-2];
        long c = nums[n-3];
        long x = nums[0],y=nums[1];
        long high = 100000,lo=-100000;
        long best = Math.max(a*b*c,x*y*a);

        long withHi = Math.max(
            Math.max(high*a*b,high*x*y),
            Math.max(high*a*x,high*b*y)
        );
        long withLo = Math.max(
            Math.max(lo*a*b,lo*x*y),
            Math.max(lo*a*x,lo*b*y)
        );


        return Math.max(best,Math.max(withHi,withLo));
    }
    
}