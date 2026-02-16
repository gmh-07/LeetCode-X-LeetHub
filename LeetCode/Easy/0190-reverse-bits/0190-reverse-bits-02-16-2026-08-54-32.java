public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i=0;
        int j=31;
        while(i<j){
            int iMask = 1<<i;
            int jMask = 1<<j;
            boolean iBit= false;
            if((n&iMask) != 0) iBit = true;
            boolean jBit= false;
            if((n&jMask) != 0) jBit = true;
            if(iBit != jBit){
                n = n^iMask;
                n = n^jMask;
            }
            i++;
            j--;
        }
        return n;
    }
}