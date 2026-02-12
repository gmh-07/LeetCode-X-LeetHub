class Solution {
    private boolean isItBalanced(int[] freqArr){
        int c=0;
        for(int freq:freqArr){
            if(freq>0){
                if(c==0) c=freq;
                else if(freq!=c) return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int n = s.length();
        int max = 0;
        for(int i=0;i<n;i++){
            int[] freqArray = new int[26];
            for(int j=i;j<n;j++){
                freqArray[s.charAt(j)-'a']++;
                if(isItBalanced(freqArray)) max = Math.max(max,j-i+1);
            }
        }
        return max;
    }
}