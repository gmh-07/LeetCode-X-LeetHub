class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=n-1;i>=1;i--){
            int j = i-1;
            map.put(nums[i],i);
            if(nums[j]<nums[i]){
                int temp = nums[j]+1;
                int getIdx = i;
                while(!map.containsKey(temp)){
                    temp++;
                }
                getIdx = map.get(temp);
                int temp1 = nums[getIdx];
                nums[getIdx] = nums[j];
                nums[j] = temp1;

                reverse(nums,i,n-1);

                break;
            }
            else if(j==0){
                reverse(nums,0,n-1);
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    private void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}