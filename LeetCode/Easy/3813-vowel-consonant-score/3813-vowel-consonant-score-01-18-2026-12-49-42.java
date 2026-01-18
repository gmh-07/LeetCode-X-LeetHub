class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0;
        int c = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') v++;
            else if(ch == ' ' || ch == '0' || ch == '1'|| ch == '2'|| ch == '3'|| ch == '4'|| ch == '5'|| ch == '6' || ch == '7'|| ch == '8'|| ch == '9'){
                continue;
            }
            else c++;
        }
        if(c>0) return (int)Math.floor(v/c);
        return 0;
    }
}