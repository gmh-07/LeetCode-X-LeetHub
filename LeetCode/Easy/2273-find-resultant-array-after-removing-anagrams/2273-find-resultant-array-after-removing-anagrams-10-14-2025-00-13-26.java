class Solution {
    private boolean isAnagram(String str1,String str2){
        if(str1.length() != str2.length()) return false;
        int[] freq = new int[26];
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<str2.length();i++){
            char ch = str2.charAt(i);
            freq[ch-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> list = new ArrayList<>();
        for(String str:words){
            list.add(str);
        }
        int i=1;
        while(i<list.size()){
            String str1 = list.get(i-1);
            String str2 = list.get(i);
            if(isAnagram(str1,str2)){
                list.remove(i);
            }
            else i++;
        }
        return list;
    }
}