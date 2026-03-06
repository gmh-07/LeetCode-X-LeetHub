class Solution {
    public boolean checkOnesSegment(String s) {
        s = s+'0';
        int n = s.length();
        int count = 0;
        int i=0,j=0;
        while(i<n && j<n){
            if(s.charAt(j)=='1') j++;
            else if(s.charAt(j)=='0'){
                if(j-i >= 1) count++;
                j++;
                i=j;
                System.out.println("i : "+i);
                System.out.println("j : "+j);
            }
        }
        System.out.println("count : "+count);
        if(j-i==n) return true;
        if(count == 1) return true;
        return false;
    }
}