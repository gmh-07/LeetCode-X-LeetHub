class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        int count = 0;
        for(int i=0;i<len;i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<n;j++){
                char currCh = strs[j].charAt(i);
                if(ch > currCh){
                    count++;
                    break;
                }
                else{
                    ch = currCh;
                }
            }
        }
        return count;
    }
}