class Solution {
    public int minLengthAfterRemovals(String s) {
        int n = s.length();
        int aNum = 0;
        int bNum = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') aNum++;
            else bNum++;
        }
        return Math.abs(aNum-bNum);
    }
}