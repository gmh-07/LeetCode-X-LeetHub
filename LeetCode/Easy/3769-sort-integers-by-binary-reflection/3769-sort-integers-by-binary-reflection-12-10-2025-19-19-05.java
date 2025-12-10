class Solution {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        int[][] sortArr = new int[n][2];
        for(int i=0;i<n;i++){
            String str = Integer.toBinaryString(nums[i]);
            StringBuilder sb = new StringBuilder(str);
            String rev = sb.reverse().toString();
            int reflection = Integer.parseInt(rev,2);
            
            sortArr[i][0] = reflection;
            sortArr[i][1] = nums[i];
        }
        Arrays.sort(sortArr,(a,b)->{
            int camp = Integer.compare(a[0],b[0]);
            if(camp != 0) return camp;
            return Integer.compare(a[1],b[1]);
        });
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = sortArr[i][1];
        }
        return res;
    }
}