package com.arrays;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums){

        Arrays.sort(nums);

        int low, high;

        List<List<Integer>> res = new LinkedList<>();

        for(int i=0; i<nums.length; i++){
            low = i+1;
            high = nums.length -1;

            while (low<high){
                if(nums[i] + nums[low] + nums[high] == 0){
                    res.add(Arrays.asList(nums[i] , nums[low] , nums[high]));
                }

                if(nums[i] + nums[low] + nums[high]<0){
                    low ++;
                }
                if(nums[i] + nums[low] + nums[high]>0){
                    high--;
                }
            }
        }

        return res;
    }


    public static void main (String args[]){
        Solution solution = new Solution();
        int [] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new LinkedList<>();
        res = solution.threeSum(array);

        res.forEach(r -> System.out.println(r));
    }
}