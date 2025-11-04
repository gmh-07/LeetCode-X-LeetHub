class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for (int i = 0; i < n - k + 1; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                map.put(nums[i + j], map.getOrDefault(nums[i + j], 0) + 1);
            }
            ArrayList<Pair> pairList = new ArrayList<>();
            for (int key : map.keySet()) {
                pairList.add(new Pair(map.get(key), key));
            }
            Collections.sort(pairList, (Pair a, Pair b) -> {
                if (a.first == b.first) {
                    return b.second - a.second; // Sort by key in descending order if values are the same
                }
                return b.first - a.first; // Otherwise, sort by value in descending order
            });
            int sum = 0;
            int breakingPoint = 0;
            for(Pair pair:pairList){
                if(breakingPoint >= x) break;
                sum += pair.first * pair.second;
                breakingPoint++;
            }
            ans[i] = sum;
        }
        return ans;
    }
}