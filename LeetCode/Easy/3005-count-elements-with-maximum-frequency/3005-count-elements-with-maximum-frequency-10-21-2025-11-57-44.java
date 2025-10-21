class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] freq = new int[101];
        int n = nums.length;
        for(int i=0;i<n;i++){
            int curr = nums[i];
            freq[curr]++;
        }
        // System.out.println(Arrays.toString(freq));
        for(int i=0;i<101;i++){
            max = Math.max(max,freq[i]);
        }
        int count = 0;
        for(int i=1;i<101;i++){
            if(freq[i]==max) count++;
        }
        return count*max;
    }
}
