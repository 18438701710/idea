package com.hh.gf.springboot.helper;

import java.util.HashMap;

/**
 * 获取一个数组中的任意两个数，使其相加等于目标数target
 *
 */
public class ArrayTest {

    public static int[] arrayMain(){
        int[] arr = new int[]{2, 6, 8, 10, 12};
        int target = 12;
        for (int i=0;i<arr.length;i++){
            for (int j =0;j<arr.length-1;j++){
                System.out.println("i:"+arr[i] +" j:"+arr[j]);
                if(arr[i]+arr[j]==target){
                    System.err.println("i:"+arr[i] +" j:"+arr[j]);
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void arrayMain2(){
        int[] nums = {7,1,3,2,11,34,6,9,32,8};
        int target = 13;
        // 结果数组
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("key:"+nums[i] +" value:"+i);
            map.put(nums[i], i);
            System.out.println(map);
        }

        for (int i = 0; i < nums.length; i++) {
            int two = target - nums[i];
            // 如果存在第二个数的数组下标&&结果的两个数不是同一个数的值
            if (map.containsKey(two) && target != 2 * two) {
                // 返回找到的两个数的数组下标
                System.out.println(i+" & "+ map.get(two));

            }
        }
    }

    public static void main(String arg[]){
        arrayMain();
        System.err.println("==========================");
        arrayMain2();
    }






}
