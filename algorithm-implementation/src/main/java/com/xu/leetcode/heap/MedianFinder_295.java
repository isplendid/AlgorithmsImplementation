package com.xu.leetcode.heap;

import java.util.PriorityQueue;

/**
 * Created by sop on 2020/8/16.
 * <p>
 * 方法一：排序，二分插入即可，返回中位数，保持有序
 * 方法二：1.大根堆： 前半部分有序数据，小根堆：后半部分有序数据
 * 2 .新加入的数据与两个对的堆顶大小关系，选择放进大根堆或者 小根堆里
 * 3. 当任何一个堆的size 比另一个 的size大于2时，进行如上调整过程。
 * <p>
 * 时间：0（logN)
 * 空间：O（N)
 */
public class MedianFinder_295 {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;


    /**
     * initialize your data structure here.
     */
    public MedianFinder_295() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (this.maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if (num <= maxHeap.peek()) {
            maxHeap.offer(num);

        } else {
            if (this.minHeap.isEmpty()) {
                minHeap.offer(num);
                return;
            }
            minHeap.offer(num);
        }
        if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        int maxSize = this.maxHeap.size();
        int minSize = this.minHeap.size();
        if (maxSize + minSize == 0) {
            return 0;
        }
        if (((maxSize + minSize) & 1) == 0) { //偶数，大顶堆和小顶堆都有元素
            int maxHead = this.maxHeap.peek();
            int minHead = this.minHeap.peek();
            return ((maxHead + minHead) * 1.0) / 2;
        } else { //奇数
            return maxSize > minSize ? maxHeap.peek() : minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder_295 m = new MedianFinder_295();
        m.addNum(1);
//        m.addNum(2);
//        System.out.println(m.findMedian());
//        m.addNum(3);
        System.out.println(m.findMedian());

    }


}
