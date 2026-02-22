class Solution {
    public boolean isDigitorialPermutation(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        map.put(2,2);
        map.put(3,6);
        map.put(4,24);
        map.put(5,120);
        map.put(6,720);
        map.put(7,5040);
        map.put(8,40320);
        map.put(9,362880);
        long sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(n>0){
            list.add(n%10);
            sum += map.get(n%10);
            n = n/10;
        }
        while(sum >0 && list.size()>0){
            for(int i=0;i<list.size();i++){
                if(list.get(i)==sum%10){
                    list.remove(i);
                    break;
                }
            }
            sum /= 10;
        }
        if(sum > 0) return false;
        if(list.size()>0) return false;
        return true;
    }
}