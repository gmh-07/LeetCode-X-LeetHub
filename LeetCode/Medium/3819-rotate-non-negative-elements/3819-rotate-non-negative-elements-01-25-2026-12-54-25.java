class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(nums[i] >= 0) list.add(nums[i]);
        }

        if(list.size() == 0) return nums;

        int size = list.size();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = list.get(i);
        }

        int effRotations = k % size;

        // Efficient rotation
        int[] rotated = new int[size];
        for(int i = 0; i < size; i++){
            rotated[i] = arr[(i + effRotations) % size];
        }

        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                nums[i] = rotated[idx++];
            }
        }

        return nums;
    }
}
