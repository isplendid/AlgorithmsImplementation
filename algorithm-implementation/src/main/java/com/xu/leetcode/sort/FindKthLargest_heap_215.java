package com.xu.leetcode.sort;

/**
 * @author xushichao
 * @date 2023/5/14 20:50
 * @desc
 */
public class FindKthLargest_heap_215 {

    public static void main(String[] args) {
        FindKthLargest_heap_215 heap  = new FindKthLargest_heap_215();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int res = heap.findKthLargest(nums, k);
        System.out.println(res);
    }

    public int findKthLargest(int[]  nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums);
        //调整k-1个元素，都放到数组末尾，第k个在堆顶
        for(int i= nums.length-1; i>= nums.length -k +1; i--) {
            swap(nums,0, i);
            --heapSize;
            heapify(nums, 0, heapSize);
        }
        return nums[0]; //堆顶元素
    }


    private void buildMaxHeap(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int half = arr.length / 2 - 1;

        for (int i = half; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }


    /**
     * 调整大顶堆: 自上而下（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    private void heapify(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) { //从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) { //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;  //跳出循环不比了
            }
        }
        arr[i] = temp; //将temp值放到最终的位置
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
