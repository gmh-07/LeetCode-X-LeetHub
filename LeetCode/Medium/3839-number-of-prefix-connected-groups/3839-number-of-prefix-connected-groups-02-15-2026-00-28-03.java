class Solution {
    public int prefixConnected(String[] words, int k) {
        int n = words.length;
        int count = 0;
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n-1;i++){
            if(isVisited[i] == true) continue;
            boolean flag = false;
            for(int j=i+1;j<n;j++){
                if(isPrefixConnected(words[i],words[j],k) && !isVisited[j]){
                    flag = true;
                    isVisited[j] = true;
                }
            }
            if(flag) count++;
        }
        return count;
    }
    private boolean isPrefixConnected(String str1,String str2,int k){
        if(str1.length() < k || str2.length() < k) return false;
        for(int i=k-1;i>=0;i--){
            if(str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }
}