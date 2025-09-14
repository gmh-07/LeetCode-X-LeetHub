import java.util.*;

class Solution {
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exact = new HashSet<>();
        HashMap<String, String> caseMap = new HashMap<>();
        HashMap<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            exact.add(w);
            caseMap.putIfAbsent(w.toLowerCase(), w);
            vowelMap.putIfAbsent(devowel(w.toLowerCase()), w);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    ans[i] = caseMap.get(lower);
                } else {
                    ans[i] = vowelMap.getOrDefault(devowel(lower), "");
                }
            }
        }
        return ans;
    }
}





// class Solution {
//     private boolean isValid(String str,String curr){
//         if(str.length() != curr.length()) return false;
//         for(int i=0;i<str.length();i++){
//             char ch1 = str.charAt(i);
//             char ch2 = curr.charAt(i);

//             if(ch1 != ch2){
//                 if((ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u') && 
//                    (ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u')){
//                     continue;
//                 } else {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     public String[] spellchecker(String[] wordlist, String[] queries) {
//         int n = queries.length;
//         HashSet<String> set = new HashSet<>();
//         HashSet<String> set2 = new HashSet<>();

//         for(int i=0;i<wordlist.length;i++){
//             set.add(wordlist[i]);
//             set2.add(wordlist[i].toLowerCase());
//         }

//         String[] ans = new String[n];
//         for(int i=0;i<n;i++){
//             String str = queries[i];
//             if(set.contains(str)){
//                 ans[i] = str;   // exact match
//             }
//             else if(set2.contains(str.toLowerCase())){
//                 for(int j=0;j<wordlist.length;j++){
//                     if(wordlist[j].toLowerCase().equals(str.toLowerCase())){
//                         ans[i] = wordlist[j];  // case-insensitive match
//                         break;
//                     }
//                 }
//             }
//             else {
//                 ans[i] = "";  // default → no match
//                 for(int j=0;j<wordlist.length;j++){
//                     if(isValid(str.toLowerCase(),wordlist[j].toLowerCase())){
//                         ans[i] = wordlist[j];  // vowel error match
//                         break;
//                     }
//                 }
//             }
//         }
//         return ans;
//     }
// }
