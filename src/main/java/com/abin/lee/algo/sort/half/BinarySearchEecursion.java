package com.abin.lee.algo.sort.half;

public class BinarySearchEecursion {


    public int binarySearch(int[] array, int low, int high, int target){
        if(low > high)
            return -1;
        int mid = low + (high-low)/2;
        if(array[mid] > target){
            return binarySearch(array, low, mid-1, target);
        }else if(array[mid] < target){
            return binarySearch(array, mid+1, high, target);
        }else{
            return mid;
        }
    }


}
