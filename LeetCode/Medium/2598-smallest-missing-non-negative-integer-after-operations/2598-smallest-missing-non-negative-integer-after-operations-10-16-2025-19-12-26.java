class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int mod = ((nums[i] % value) + value) % value;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        System.out.println(map);
        int mex = 0;
        while(true){
            int mod = mex%value;
            if(map.containsKey(mod)){
                map.put(mod,map.get(mod)-1);
                if(map.get(mod)==0){
                    map.remove(mod);
                }
                mex++;
            }
            else return mex;
        }
        // return mex;
    }
}