package com.xu.leetcode.sort;

import java.util.PriorityQueue;

/**
 * Created by sop on 2020/3/20.
 * PriorityQueue 默认小根堆，大根堆需要重写比较器
 *
 */
public class KLeastNumbers_40 {

    //最小的k个数， 大顶堆.   (a,b) -> b-a
    public int[] smallestK(int[] arr, int k) {
        if(null == arr || arr.length == 0 || k==0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a );
        int[] ans = new int[k];


        for(int a: arr) {
            if(pq.size() == k && pq.peek() <= a) {
                continue;
            }
            if(pq.size() == k ) {
                pq.poll();
            }
            pq.add(a);
        }

        for(int i = k-1; i>=0; i--) {
            ans[i] = pq.poll();
        }

        return ans;

    }


    /***
     * 由于使用了一个大小为 k 的堆，空间复杂度为 O(k)
     * 入堆和出堆操作的时间复杂度均为O(nlogk)，每个元素都需要进行一次入堆操作，
     * 故算法的时间复杂度为 O(nlogk)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {

        if(k==0){
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2,i1));
        for(int e:arr){
            if(heap.isEmpty() || heap.size() <= k || e < heap.peek() ){
                heap.offer(e);
            }
            if(k < heap.size()){
                heap.poll();
            }
        }

        int[] res = new int[heap.size()];
        int j=0;
        for(int e:heap){
            res[j++] = e;
        }
        return res;

    }

    /***
     * 而快速选择（quick select）算法的不同之处在于，接下来只需要递归地选择一侧的数组。
     * 快速选择算法想当于一个“不完全”的快速排序，因为我们只需要知道最小的 k 个数是哪些，并不需要知道它们的顺序。
     我们的目的是寻找最小的 kk 个数。假设经过一次 partition 操作，枢纽元素位于下标 mm，也就是说，左侧的数组有 mm 个元素，是原数组中最小的 mm 个数。那么：

     若 k = mk=m，我们就找到了最小的 kk 个数，就是左侧的数组；
     若 k<mk<m ，则最小的 kk 个数一定都在左侧数组中，我们只需要对左侧数组递归地 parition 即可；
     若 k>mk>m，则左侧数组中的 mm 个数都属于最小的 kk 个数，我们还需要在右侧数组中寻找最小的 k-mk−m 个数，对右侧数组递归地 partition 即可。
     https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_quick(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);

        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArray(arr, lo, m-1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            partitionArray(arr, m+1, hi, k);
        }
    }

    // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
// 代码参考 Sedgewick 的《算法4》
    int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
