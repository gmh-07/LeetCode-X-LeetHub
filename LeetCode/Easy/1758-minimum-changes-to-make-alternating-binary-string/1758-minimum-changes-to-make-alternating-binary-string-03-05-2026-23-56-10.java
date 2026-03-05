class Solution {
    public int minOperations(String s) {
        int startWithZeroCount = 0;
        boolean wantZero = true;
        for(int i=0;i<s.length();i++){
            if(wantZero==true && s.charAt(i)=='0'){
                wantZero = false;
            }
            else if(wantZero == false && s.charAt(i)=='1'){
                wantZero = true;
            }
            else if((wantZero==true && s.charAt(i)=='1') || (wantZero==false && s.charAt(i)=='0')){
                startWithZeroCount++;
                wantZero = !wantZero;
            }
        }
        int startWithOneCount = 0;
        wantZero = false;
        for(int i=0;i<s.length();i++){
            if(wantZero==true && s.charAt(i)=='0'){
                wantZero = false;
            }
            else if(wantZero == false && s.charAt(i)=='1'){
                wantZero = true;
            }
            else if((wantZero==true && s.charAt(i)=='1') || (wantZero==false && s.charAt(i)=='0')){
                startWithOneCount++;
                wantZero = !wantZero;
            }
        }

        return Math.min(startWithZeroCount,startWithOneCount);
    }
}