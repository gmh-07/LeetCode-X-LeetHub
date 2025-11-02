class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallestEle = nums[0];
        int largestEle = nums[0];
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] < smallestEle){
                smallestEle = nums[i];
            }
            if(nums[i]>largestEle){
                largestEle = nums[i];
            }
        }
        boolean[] visited = new boolean[largestEle-smallestEle + 1];
        for(int value:nums){
            visited[value - smallestEle] = true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            if(!visited[i]) list.add(smallestEle+i);
        }
        return list;
    }
}