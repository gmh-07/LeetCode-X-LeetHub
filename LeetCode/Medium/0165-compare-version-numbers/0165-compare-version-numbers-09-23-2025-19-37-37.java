class Solution {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        int[] nums1 = new int[parts1.length];
        for (int i = 0; i < parts1.length; i++) {
            nums1[i] = Integer.parseInt(parts1[i]); 
        }
        String[] parts2 = version2.split("\\."); 
        int[] nums2 = new int[parts2.length];
        for (int i = 0; i < parts2.length; i++) {
            nums2[i] = Integer.parseInt(parts2[i]);
        }
        int min = Math.min(parts1.length,parts2.length);
        for(int i=0;i<min;i++){
            if(nums1[i]<nums2[i]) return -1;
            if(nums1[i]>nums2[i]) return 1;
        }
        if(nums1.length > min){
            for(int i=min;i<nums1.length;i++){
                if(nums1[i] > 0) return 1;
            }
        }
        if(nums2.length > min){
            for(int i=min;i<nums2.length;i++){
                if(nums2[i] > 0) return -1;
            }
        }
        return 0;
    }
}