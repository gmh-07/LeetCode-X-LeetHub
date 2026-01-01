class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            else{
            arr[i] = 0;
            }
        }
        int[] brr = new int[n + 1];
        brr[0] = 1;
        
        return brr;
    }
}
// loop ke andar wali baat: 
// if(if) codition satisfies then it will return the arr so no further loop will be traversed
// and loop will be broken automatically because after return no loop remains agar else condition chali array ke sabse
// last element ko 0 kardo and loop ko chalao,aur check karo agar vo 9 se chota hai to uske last element ko ++ kardo and
// arr ko return karo so at this condition loop will also break at that moment.
// e.g. {1,9} will be {2,0}
// Loop ke bahar wali baat:
// Let's take the input [9, 9, 9] as an example:

// Initialization:

// int n = arr.length; initializes n to the length of the input array, which is 3.
// For Loop Execution:

// The for loop starts from the last element (index n - 1, which is 2) and moves towards the first element (index 0).
// First Iteration (i = 2):

// if (arr[i] < 9) { ... } checks if the current digit is less than 9. Since arr[2] is 9, this condition is false.
// arr[i] = 0; sets arr[2] to 0. The array now looks like [9, 9, 0].
// Second Iteration (i = 1):

// if (arr[i] < 9) { ... } checks if the current digit is less than 9. Since arr[1] is 9, this condition is false.
// arr[i] = 0; sets arr[1] to 0. The array now looks like [9, 0, 0].
// Third Iteration (i = 0):

// if (arr[i] < 9) { ... } checks if the current digit is less than 9. Since arr[0] is 9, this condition is false.
// arr[i] = 0; sets arr[0] to 0. The array now looks like [0, 0, 0].
// After the Loop:

// At this point, all elements have been processed and set to 0, indicating that the entire number was composed of 9s and the carry-over needs to be handled.
// The code then creates a new array brr of length n + 1 (4 in this case) to accommodate the extra digit resulting from the carry-over.
// Creating and Returning the New Array
// New Array Initialization:

// int[] brr = new int[n + 1]; creates a new array brr of length 4, which is [0, 0, 0, 0] by default.
// brr[0] = 1; sets the first element to 1, making the new array [1, 0, 0, 0].
// Return the New Array:

// return brr; returns the new array, which correctly represents the number 1000 after incrementing 999.
