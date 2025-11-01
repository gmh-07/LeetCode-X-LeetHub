//in this code there is just a minor change of returning mid instead of arr[mid] in binary search method analyse this code what may be the proper issue
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        int[] searchArr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            searchArr[i] = intervals[i][0];
            map.put(intervals[i][0],i);
        }
        Arrays.sort(searchArr);
        for(int i=0;i<n;i++){
            int start = BinarySearch(searchArr,intervals[i][1]);
            if(start == -1){
                ans[i] = -1;
            }
            else{
                ans[i] = map.get(searchArr[start]);
            }
        }
        return ans;
    }
    public int BinarySearch(int[] arr,int target){
        int n = arr.length;
        int low=0;
        int high=n-1;
        int ans = -1;
        while(low <= high){
            int mid = ((high-low)/2)+low;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] >= target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}




// class Solution {
//     public int[] findRightInterval(int[][] intervals) {
//         int n = intervals.length;
//         int[] ans = new int[n];
//         int[] searchArr = new int[n];
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i=0;i<n;i++){
//             searchArr[i] = intervals[i][0];
//             map.put(intervals[i][0],i);
//         }
//         Arrays.sort(searchArr);
//         for(int i=0;i<n;i++){
//             int start = BinarySearch(searchArr,intervals[i][1]);
//             if(start == -1){
//                 ans[i] = -1;
//             }
//             else{
//                 ans[i] = map.get(start);
//             }
//         }
//         return ans;
//     }
//     public int BinarySearch(int[] arr,int target){
//         int n = arr.length;
//         int low=0;
//         int high=n-1;
//         int ans = -1;
//         while(low <= high){
//             int mid = ((high-low)/2)+low;
//             if(arr[mid] == target){
//                 return arr[mid];
//             }
//             else if(arr[mid] >= target){
//                 ans = arr[mid];
//                 high = mid-1;
//             }
//             else{
//                 low = mid+1;
//             }
//         }
//         return ans;
//     }
// }

// The issue with your code is that the binarySearch method returns the value of the next possible interval's start point but doesn't ensure that it corresponds to a valid index in the sorted array for all cases. Specifically, it can fail when intervals are closely spaced with large numbers of intervals, as seen in this input.

// Here is how to fix the problem:

// Observations:
// The binary search is correct in finding the smallest value greater than or equal to the target. However, the map.get(start) logic assumes that start is always in the map, which may not be the case in edge situations like duplicate or missing interval values.

// Key Problem:
// Your code doesn't account for intervals where target equals the end of one interval but is not present as a start in the array.