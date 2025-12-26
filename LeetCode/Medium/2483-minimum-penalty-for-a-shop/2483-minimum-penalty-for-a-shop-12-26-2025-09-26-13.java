
//This code is written to be readable we can do optimizations eliminating the calculation of yesNum and many of the extra arrays
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int yesNum = 0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y') yesNum++;
        }
        int[] prefixArr = new int[n+1];
        for(int i=1;i<n+1;i++){//initially array has all elements as zero
            prefixArr[i] = prefixArr[i-1];
            if(customers.charAt(i-1)=='N'){
                prefixArr[i] += 1;
            }
        }
        int[] suffixArr = new int[n+1];
        suffixArr[0] = yesNum;
        for(int i=1;i<n+1;i++){
            suffixArr[i] = suffixArr[i-1];// **Carry over the previous value**
            if(customers.charAt(i-1)=='Y'){
                suffixArr[i] -= 1;
            }
        }
        int[] penalty = new int[n+1];
        int minPenaulty = Integer.MAX_VALUE;
        for(int i=0;i<n+1;i++){
            penalty[i] = prefixArr[i] + suffixArr[i];
            minPenaulty = Math.min(minPenaulty,penalty[i]);
        }
        for(int i=0;i<n+1;i++){
            if(penalty[i] == minPenaulty) return i;
        }
        return 0;
    }
}