//O(1)
class Solution {
    public int minCost(int n) {
        return n*(n-1)/2;
    }
}






// O(n)
// class Solution {
//     public int minCost(int n) {
//         int ans = 0;
//         for(int i=1;i<n;i++){
//             ans += i;
//         }
//         return ans;
//     }
// }