class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        st.push((long)nums[0]);
        int n = nums.length;
        for(int i=1;i<n;i++){
            long sum = nums[i];
            while(!st.isEmpty() && st.peek() == sum){
                sum = st.pop() + sum;
            }
            st.push(sum);
        }
        ArrayList<Long> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}