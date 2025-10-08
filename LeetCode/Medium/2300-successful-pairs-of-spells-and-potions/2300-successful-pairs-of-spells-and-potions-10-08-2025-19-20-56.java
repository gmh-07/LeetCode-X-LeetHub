class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] ans = new int[n];
        int m = potions.length;
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int s1 = spells[i];
            if((long)s1*potions[m-1] < success){
                ans[i] = 0;
                continue;
            }
            int low = 0;
            int high = m-1;
            while(low<=high){
                int mid = ((high-low)/2)+low;
                int s2 = potions[mid];
                if((long)s1*s2 >= success) high = mid-1;
                else low = mid+1;
            }
            ans[i] = m-low;
        }
        return ans;
    }
}