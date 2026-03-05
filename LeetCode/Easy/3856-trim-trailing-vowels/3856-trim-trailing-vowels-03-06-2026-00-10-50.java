class Solution {
    public String trimTrailingVowels(String s) {
        int n =s.length();
        int idx = -1;
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            
            if(ch != 'a' && ch !='e' && ch !='o' && ch != 'i' && ch !='u'){
                idx = i;
                break;  // just little change than wrong code
            }
        }
        return s.substring(0,idx+1);
    }
}




// This code is wrong
// class Solution {
//     public String trimTrailingVowels(String s) {
//         int n =s.length();
//         int idx = -1;
//         for(int i=n-1;i>=0;i--){
//             char ch = s.charAt(i);
//             idx = i;
//             if(ch != 'a' && ch !='e' && ch !='o' && ch != 'i' && ch !='u') break;
//         }
//         return s.substring(0,idx+1);
//     }
// }