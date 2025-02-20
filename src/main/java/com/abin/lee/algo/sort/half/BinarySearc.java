package com.abin.lee.algo.sort.half;

import org.junit.Test;

public class BinarySearc {


    public int binarySearchRecursion(int[] array, int low, int high, int target){
        if(low > high)
            return -1;
        int mid = low + (high-low)/2;
        if(array[mid] > target){
            return binarySearchRecursion(array, low, mid-1, target);
        }else if(array[mid] < target){
            return binarySearchRecursion(array, mid+1, high, target);
        }else{
            return mid;
        }
    }


    @Test
    public void testRecursion(){
        int[] arr1 = new int[]{1,2,3,4,5};
        int result = binarySearchRecursion(arr1,0,4, 4);
        System.out.println("result="+result);
    }



    public int binarySearchLoop(int[] array, int target){
        int low = 0;
        int high = array.length-1;
        while(low <= high){
            int mid =low + (high-low)/2;
            if(array[mid] > target){
                high = mid - 1;
            }else if(array[mid] < target){
                low = mid +1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    @Test
    public void testLoop(){
        int[] arr1 = new int[]{1,2,3,4,5};
        int result = binarySearchLoop(arr1, 4);
        System.out.println("result="+result);
    }


}
