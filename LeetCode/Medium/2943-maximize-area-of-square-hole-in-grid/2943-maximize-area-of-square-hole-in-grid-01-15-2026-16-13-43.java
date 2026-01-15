class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxHor = 0;
        int maxVer = 0;
        int count = 0;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                count++;
            }
            else{
                count = 0;
            }
            maxHor = Math.max(maxHor,count);
        }
        count = 0;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                count++;
            }
            else{
                count = 0;
            }
            maxVer = Math.max(maxVer,count);
        }
        System.out.println(Arrays.toString(hBars));
        System.out.println(Arrays.toString(vBars));

        System.out.println(maxHor);
        System.out.println(maxVer);

        int side = Math.min(maxHor+2,maxVer+2);
        return side*side;
    }
}