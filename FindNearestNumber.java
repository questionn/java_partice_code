package com.tom.dictionaries_arithmetic;

import java.util.Arrays;

public class FindNearestNumber {
    /**
     * 问题：给定一个整数，实现一个方法求出离该整数最近的大于自身的“换位数"
     * 全排列之后的结果 ， 那个大于且最近的数
     * <p>
     * 思路：
     * 从后找出一个逆序的区域  在找出他的前一位
     * 把这一位与逆序区域的大于它的值  交换   （从后向前遍历）
     * 逆序区域 变为有序
     */
    public static int[] findNearestNumberAct(int[] numbers) {
        //首先不改变原来的值
        int[] numbersCopy = Arrays.copyOf(numbers,numbers.length);
        //向前查看逆序区域，找出逆序区域的前一位
        int index = findTransferPoint(numbersCopy);    //实际上是前一位
        //如果返回的是0   则代表数组逆序
        if(index == 0)
            return null;
        //交换位置
        exchangeHead(numbersCopy,index);
        //将逆序区域变为顺序
        reverse(numbersCopy,index);
        return numbersCopy;

    }

    private static int[] reverse(int[] numbersCopy, int index) {
        //因为区域之前整体是  逆序的
        // 5 2 2 1
        //直接使用交换
        int left = index;
        int right = numbersCopy.length-1;

        while (left < right){
            int tmp = numbersCopy[left];
            numbersCopy[left] = numbersCopy[right];
            numbersCopy[right] = tmp;

            left++;
            right--;
        }
        return numbersCopy;
    }

    private static int[] exchangeHead(int[] numbersCopy, int index) {
        int head = index-1;
        for (int i = numbersCopy.length-1; i > 0 ; i--) {
            if(numbersCopy[i] > numbersCopy[head]){
                int tmp = numbersCopy[i];
                numbersCopy[i] = numbersCopy[head];
                numbersCopy[head] = tmp;
                break;
            }
        }
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbersCopy) {
        if(numbersCopy == null || numbersCopy.length == 0)
            return 0;

        for (int i = numbersCopy.length-1; i > 0 ; i--) {
            if(numbersCopy[i] > numbersCopy[i-1]){
                return i;  //实际是i-1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,5,4,3};
        int[] ret = findNearestNumberAct(array);
        for (int j = 0; j < ret.length; j++) {
            System.out.print(ret[j] + " ");
        }
        System.out.println();
    }

}
