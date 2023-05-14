package com.xu.leetcode.sort;

class ArrayUtils {
    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


/***
 *
 * 完全二叉树，比较适合用数组存储，不需要存储左右指针，数组下标访问
 * trick: 从下标为1开始， 下标i节点的左子节点 2i,右子节点 2i + 1; 父节点为i/2
 *
 * 插入新元素： （堆化） 从下往上调整元素 heapify
 * 删除堆顶元素： 最后一个元素放到堆顶，从上往下的堆化heapify方法。 (满足完全二叉树的特性，不会重现空洞）
 *
 * 建堆的思路：
 *   1） 从前往后处理数组数据，并且每个数据插入堆中时，都是从下往上堆化。  （插入）
 * √ 2） 从后往前处理数组，并且每个数据都是从上往下堆化。   √   从非叶子节点开始堆化： length(array)/2 -1 ; (对于完全二叉树来说，下标从 n/2+1 到 n 的节点都是叶子节点。)
 * 建堆时间复杂度：O(N)
 * 排序的时间复杂度 NlogN
 *
 * 堆排序不是稳定的排序算法，因为在排序的过程，存在将堆的最后一个节点跟堆顶节点互换的操作，所以就有可能改变值相同数据的原始相对顺序。
 *
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1）
 *
 *
 * 注意： 该排序算法是从数组0开始的（而非1）
 * 下标i左节点 2i+1,  右节点2i+2, 最后一个非叶节点 n/2 -1；
 * 下标i的父节点为 i/2-1;
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        System.out.println("Before heap: ");
        ArrayUtils.printArray(array);

        heapSort(array);

        System.out.println("After heap sort: ");
        ArrayUtils.printArray(array);
    }

    private static void heapSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        //step 1:  初始化建大顶堆
        buildMaxHeap(array);

        //step2: 排序， 堆顶与最后一个元素交换，最大元素放到下标i的位置， 自上而下堆化
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            ajustHeap(array,0, i);
        }
    }

	//建大顶堆
	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = array.length / 2 - 1; // 最后一个非叶节点： n/2 -1;
		for (int i = half; i >= 0; i--) {  //非叶节点，也是从上往下堆化
			ajustHeap(array, i, array.length);
		}
	}


    /***
     *
     * 递归方式
     *
     * 自上而下堆化 （排序阶段：将堆顶元素与尾部交换）
     *
     * 下标i节点的左子节点： (2*i+1);
     * 下标i节点的右子节点： (2*i+2);
     * @param array
     * @param index  起始下标
     * @param heapSize  待调整的堆 数量
     */
    private static void ajustHeap(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            swap(array, index, largest);
            ajustHeap(array, largest, heapSize);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    //堆化的非递归实现
    public void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;

        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }

            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != index) {
                swap(arr, index, largest);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }


}
