class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0,j=n-1;
        int max = 0;
        while(i<j){
            int area = (j-i)*Math.min(height[i],height[j]);
            max = Math.max(max,area);
            if(height[i] < height[j]){
                i++;
            }
            else j--;
        }
        return max;
    }
}


// //Brute force approach: Giving TLE
// class Solution {
//     public int maxArea(int[] height) {
//         int n = height.length;
//         int maxArea = 0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 int minHeight = Math.min(height[i],height[j]);
//                 int width = j-i;
//                 int area = minHeight * width;
//                 maxArea = Math.max(maxArea,area);
//             }
//         }
//         return maxArea;
//     }
// }