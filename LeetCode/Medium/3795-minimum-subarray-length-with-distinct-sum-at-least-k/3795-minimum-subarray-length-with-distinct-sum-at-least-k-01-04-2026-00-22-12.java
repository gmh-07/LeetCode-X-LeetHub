class Solution {
    public int minLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int i = 0;
        long distinctSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {

            // add nums[j]
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if (map.get(nums[j]) == 1) {
                distinctSum += nums[j];
            }

            // try shrinking from left
            while (distinctSum >= k) {
                ans = Math.min(ans, j - i + 1);

                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    distinctSum -= nums[i];
                }
                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
