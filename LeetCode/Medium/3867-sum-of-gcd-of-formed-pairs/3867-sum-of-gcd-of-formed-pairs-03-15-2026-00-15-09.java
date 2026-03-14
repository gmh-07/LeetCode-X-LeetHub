class Solution {
    private int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] maxArr = new int[n];
        int max = nums[0];
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            maxArr[i] = max;
        }
        // System.out.println(Arrays.toString(maxArr));

        int[] prefixGcd = new int[n];
        for(int i=0;i<n;i++){
            prefixGcd[i] = gcd(maxArr[i],nums[i]);
        }

        Arrays.sort(prefixGcd);
        // System.out.println(Arrays.toString(prefixGcd));

        long sum = 0;
        int i=0;
        int j=n-1;
        while(i<j){
            sum += (long)gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }
}