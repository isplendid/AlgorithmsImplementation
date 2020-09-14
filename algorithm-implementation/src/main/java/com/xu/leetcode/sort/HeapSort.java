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

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}


/****
 * 二叉堆的操作： insert(上浮）：从小到上操作， deleteMax (下沉）：从上到下操作
 * 堆是一种完全二叉树
 * 插入数据和删除堆顶元素的主要逻辑就是堆化，
 * 所以，往堆中插入一个元素和删除堆顶元素的时间复杂度都是
 *
 * 基于堆结构实现的排序算法称为堆排序，它时间复杂度非常稳定为，并且它还是原地排序算法。
 * 其过程可以大致分解为两个大的步骤：建堆和排序
 *
 * 建堆过程： 而第二种实现思路，是从后往前处理数组，并且每个数据都是从上往下堆化
 * https://www.zdaiot.com/DataStructureAlgorithm/27%E5%A0%86%E5%92%8C%E5%A0%86%E6%8E%92%E5%BA%8F%EF%BC%9A%E4%B8%BA%E4%BB%80%E4%B9%88%E8%AF%B4%E5%A0%86%E6%8E%92%E5%BA%8F%E6%B2%A1%E6%9C%89%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E5%BF%AB/
 *
 *
 */

/***
 * 堆排序时间复杂度一般认为就是O(nlogn)级
 * 空间O(1）
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
        //step 1:  构造大顶堆
        buildMaxHeap(array);

        //step2: 交换堆顶元素与末尾元素 + 调整堆结构
        for (int i = array.length - 1; i >= 1; i--) {
            ArrayUtils.exchangeElements(array, 0, i);  //将堆顶元素与末尾元素进行交换
            ajustHeap(array,0, i);  //重新对堆进行调整
        }
    }

	//初始化最大堆
	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = array.length / 2 - 1; //从第一个非叶子结点从下至上，从右至左调整结构
		for (int i = half; i >= 0; i--) {
			ajustHeap(array, i, array.length);
		}
	}


	/***
	 *  调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上） 从上到下
     *  性质一: 索引为i的左孩子的索引是 (2*i+1);
     * 性质二: 索引为i的左孩子的索引是 (2*i+2);
     * 性质三: 索引为i的父结点的索引是 floor((i-1)/2);
	 * @param array
	 * @param heapSize  待排序堆长度
	 * @param index 当前元素索引
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
            ArrayUtils.exchangeElements(array, index, largest);
            ajustHeap(array, largest, heapSize);
        }
    }









	//调整最大堆
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


	private void swap(int[] arr, int parent, int index) {
		int tmp = arr[parent];
		arr[parent] = arr[index];
		arr[index] = tmp;
	}


}
