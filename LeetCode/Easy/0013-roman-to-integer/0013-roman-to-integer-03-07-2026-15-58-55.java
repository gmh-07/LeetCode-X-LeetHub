// import java.util.*;

// class Solution {
//     public int romanToInt(String s) {

//         HashMap<Character,Integer> map = new HashMap<>();
//         map.put('I',1);
//         map.put('V',5);
//         map.put('X',10);
//         map.put('L',50);
//         map.put('C',100);
//         map.put('D',500);
//         map.put('M',1000);

//         int sum = 0;

//         for(int i = 0; i < s.length(); i++){

//             int value = map.get(s.charAt(i));

//             if(i < s.length()-1 && value < map.get(s.charAt(i+1))){
//                 sum -= value;
//             }
//             else{
//                 sum += value;
//             }
//         }

//         return sum;
//     }
// }





class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        int i = s.length()-1;
        while(i>=0){
            char ch = s.charAt(i);
            if(ch=='I' && i<s.length()-1){
                if(s.charAt(i+1)=='V' || s.charAt(i+1)=='X') sum -= 1;
            }
            else if(ch=='X' && i<s.length()-1){
                if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C') sum -= 10;
            }
            else if(ch=='C' && i<s.length()-1){
                if(s.charAt(i+1)=='D' || s.charAt(i+1)=='M') sum -= 100;
            }
            else {
                sum += map.get(ch);
            }
            i--;
        }
        return sum;
    }
}