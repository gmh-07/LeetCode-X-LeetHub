class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    int a = digits[i];
                    int b = digits[j];
                    int c = digits[k];
                    if(a != 0 && (a*100+b*10+c)%2 == 0) set.add((a*100+b*10+c));
                    if(a != 0 && (a*100+c*10+b)%2 == 0) set.add((a*100+c*10+b));
                    if(b != 0 && (b*100+a*10+c)%2 == 0) set.add((b*100+a*10+c));
                    if(b != 0 && (b*100+c*10+a)%2 == 0) set.add((b*100+c*10+a));
                    if(c != 0 && (c*100+b*10+a)%2 == 0) set.add((c*100+b*10+a));
                    if(c != 0 && (c*100+a*10+b)%2 == 0) set.add((c*100+a*10+b));
                }
            }
        }
        return set.size();
    }
}






/*
// Mathematical Intuition through permutations

class Solution {
    public int totalNumbers(int[] digits) {
        int even = 0;
        int zero = 0;
        int n = digits.length;
        for(int i=0;i<n;i++){
            if(digits[i]%2==0) even++;
            if(digits[i]==0) zero++;
        }
        return even * (n-1) * (n-2);
    }
}

*/