
//Optimized code(Binary search):
class Solution {
    public int countNegatives(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int count = 0;
        int i=a-1,j=0;
        while(i>=0 && j<b){
            if(grid[i][j] < 0){
                count += b-j;
                i--;
            }
            else{
                j++;
            }
        }
        return count;
    }
}


// //Brute Force:
// class Solution {
//     public int countNegatives(int[][] grid) {
//         int a = grid.length;
//         int b = grid[0].length;
//         int count = 0;
//         for(int i=0;i<a;i++){
//             for(int j=0;j<b;j++){
//                 if(grid[i][j]<0) count++;
//             }
//         }
//         return count;
//     }
// }