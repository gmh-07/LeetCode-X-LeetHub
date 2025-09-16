class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int count = 0;
        int mem = mainTank;
        while(mainTank >= 5){
            if(additionalTank <= 0) break;
            mainTank -= 5;
            additionalTank--;
            mainTank++;
            count++;
        }
        return (mem + count)*10;
    }
}