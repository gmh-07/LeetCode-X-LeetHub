class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return n;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int[] newArr = new int[map.size()];
        int idx = 0;
        for(int key:map.keySet()){
            newArr[idx++] = key;
        }
        int count = 0;
        Arrays.sort(newArr);
        int len = n;
        for(int i=0;i<newArr.length;i++){
            int currElementsBeyond = len - map.get(newArr[i]);
            if(currElementsBeyond >= k){
                count += map.get(newArr[i]);
            }
            len -= map.get(newArr[i]);
        }
        return count;
    }
}