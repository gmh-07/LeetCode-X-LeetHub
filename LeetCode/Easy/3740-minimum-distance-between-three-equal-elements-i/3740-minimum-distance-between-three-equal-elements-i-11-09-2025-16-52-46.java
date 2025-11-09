class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n<3) return -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(nums[i] != nums[j]) continue;
                for(int k=j+1;k<n;k++){
                    if(nums[i] == nums[j] && nums[i] == nums[k] && nums[j] == nums[k]){
                        System.out.println("i : "+i);
                        System.out.println("j : "+j);
                        System.out.println("k : "+k);

                        int sum = Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                        System.out.println("sum : "+sum);

                        min = Math.min(min,sum);
                    }
                }
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
}