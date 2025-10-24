class Solution {
    public int nextBeautifulNumber(int n) {
        while(!isBalanced(n+1)){
            n++;
        }
        return n+1;
    }
    private boolean isBalanced(int num){
        String numStr = String.valueOf(num);
        int[] freq = new int[10];
        Arrays.fill(freq,-1);
        int n = numStr.length();
        for(int i=0;i<n;i++){
            char ch = numStr.charAt(i);
            if(freq[(int)ch-48] == -1){
                freq[(int)ch-48] = 1;
            }
            else{
                freq[(int)ch-48]++;
            }
        }
        for(int i=0;i<10;i++){
            if(freq[i] != -1 && freq[i] != i) return false;
        }
        return true;
    }
}