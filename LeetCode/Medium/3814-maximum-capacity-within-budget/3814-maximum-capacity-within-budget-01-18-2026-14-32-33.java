class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = costs[i];
            arr[i][1] = capacity[i];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int[] prefMax = new int[n];
        prefMax[0] = arr[0][1];
        for(int i=1;i<n;i++){
            prefMax[i] = Math.max(prefMax[i-1],arr[i][1]);
        }

        int max = 0;
        for(int i=0;i<n;i++){
            if(arr[i][0]<budget) max = Math.max(max,arr[i][1]);
        }

        for(int i=0;i<n;i++){
            int currCost = arr[i][0];
            int remaining = budget - currCost;

            int high = i-1;
            int low = 0;
            int idx = -1;
            while(low <= high){
                int mid = (high-low)/2+low;
                int newCost = arr[mid][0];
                if(newCost >= remaining) high = mid-1;
                else{
                    idx = mid;
                    low = mid+1;
                }
            }
            if(idx != -1){
                max = Math.max(max,arr[i][1]+prefMax[idx]);
            }
        }


        // for(int test=0;test<n;test++){
        //     System.out.println(Arrays.toString(arr[test]));
        // }
        // System.out.println(Arrays.toString(prefMax));
        
        return max;
    }
}