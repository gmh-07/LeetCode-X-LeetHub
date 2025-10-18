class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(map);
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int start = Math.max(entry.getKey()-k,prev+1);
            int end = entry.getKey() + k;
            if (start > end) continue;
            int gap = end - start + 1;
            int min = Math.min(entry.getValue(),gap);
            prev = start+min-1;
            count += min;
            System.out.println("start : " + start);
            System.out.println("end : " + end);
            System.out.println("gap : " + gap);
            System.out.println("min : " + min);
            System.out.println("prev : " + prev);
            System.out.println("count : " + count);

            System.out.println("+++++++++++++++++++++++++++++++++++++++");

        }
        return count;
    }
}