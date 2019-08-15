package com.tom.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OfferTwo {
    //最小的k个数   建堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //判断条件是否符合
        if(input == null || input.length == 0 || k > input.length){
            return null;
        }
        //建立一个大堆
        PriorityQueue<Integer> likeBigHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //判断
        for ( Integer num:input
             ) {
            if (likeBigHeap.size() < k){
                likeBigHeap.offer(num);
            }else if(likeBigHeap.peek() > num){
                likeBigHeap.poll();
                likeBigHeap.offer(num);
            }
        }

        //返回list
        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer num:likeBigHeap
             ) {
            integers.add(num);
        }

        return integers;
    }

}