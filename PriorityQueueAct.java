package com.structure.PriorityQueue;

import java.util.Arrays;

public class PriorityQueueAct {

    //优先级队列：
    /**
     * 概念：作为一个队列的“升级”，每次出队的是最大值或者最小值（最大有限队列，最小优先队列）
     * 队列：先进先出
     *
     * 实现：使用大堆或者小堆实现
     *
     * 时间复杂度：log(n)
     *
     */

    private int[] array;
    private int size;

    public PriorityQueueAct(){
        //初始化
        array = new int[32];
        size = 0;
    }

    /**
     *
     * 入队操作
     */

    public void enQueue(int key){
        //扩容
        if(size >= array.length){
            resize();
        }
        array[size++] = key;
        //堆调整
        upAdjust();
    }

    /**
     *
     * 出队操作
     */
    public int outQueue() throws Exception{
        if(size <= 0){
            throw new NullPointerException("无数据");
        }
        //获得堆顶元素
        int head = array[0];
        //移动最后一个元素
        array[0] = array[--size];
        //向下调整
        downAdjust();
        return head;
    }

    //向上调整  大堆
    private void upAdjust() {
        if(size <= 0){
            throw new NullPointerException("无数据");
        }
        //调整最后一个元素
        int child = size-1;
        int parent = (child-1)/2;

        //如果child到堆顶完毕
        while(child > 0){
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;

                //继续调整
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }


    }

    private void downAdjust() {
        //节点
        //每次从0进行一次调整   因为每次0位置要进行交换
        int parent = 0;
        int child = 1;

        while(child < size){ //有可能最后一个元素
            if(child+1 < size && array[child+1] >array[child]){
                child++;
            }

            if(array[child] > array[parent]){
                //交换
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                //继续调整
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }
    }

    private void resize() {
        //扩容
        this.array = Arrays.copyOf(this.array,array.length*2);
    }

}
