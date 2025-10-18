class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        long prev = Long.MIN_VALUE; // use long to avoid overflow
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            long val = entry.getKey();
            int f = entry.getValue();

            long start = Math.max(prev + 1, val - k);
            long end = val + k;

            if (start > end) continue;

            long available = end - start + 1;
            long used = Math.min(f, available);

            count += used;
            prev = start + used - 1; // ✅ update to last used position
        }

        return count;
    }
}
