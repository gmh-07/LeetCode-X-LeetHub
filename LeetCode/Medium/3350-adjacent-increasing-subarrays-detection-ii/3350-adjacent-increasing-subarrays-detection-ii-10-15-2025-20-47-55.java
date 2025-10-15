class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int prevRun = 0;  // length of previous increasing run
        int currRun = 1;  // length of current increasing run
        int k = 0;        // result (max possible k)

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                currRun++;
            } else {
                // compare consecutive runs
                k = Math.max(k, Math.min(prevRun, currRun));
                prevRun = currRun;
                currRun = 1;
            }
        }

        // handle the last run (if the array ends with increasing sequence)
        k = Math.max(k, Math.min(prevRun, currRun));
        return k;
    }
}
