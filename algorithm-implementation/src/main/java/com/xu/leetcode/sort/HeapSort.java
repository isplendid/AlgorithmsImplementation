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
 * ����ѵĲ����� insert(�ϸ�������С���ϲ����� deleteMax (�³��������ϵ��²���
 * ����һ����ȫ������
 * �������ݺ�ɾ���Ѷ�Ԫ�ص���Ҫ�߼����Ƕѻ���
 * ���ԣ������в���һ��Ԫ�غ�ɾ���Ѷ�Ԫ�ص�ʱ�临�Ӷȶ���
 *
 * ���ڶѽṹʵ�ֵ������㷨��Ϊ��������ʱ�临�Ӷȷǳ��ȶ�Ϊ������������ԭ�������㷨��
 * ����̿��Դ��·ֽ�Ϊ������Ĳ��裺���Ѻ�����
 *
 * ���ѹ��̣� ���ڶ���ʵ��˼·���ǴӺ���ǰ�������飬����ÿ�����ݶ��Ǵ������¶ѻ�
 * https://www.zdaiot.com/DataStructureAlgorithm/27%E5%A0%86%E5%92%8C%E5%A0%86%E6%8E%92%E5%BA%8F%EF%BC%9A%E4%B8%BA%E4%BB%80%E4%B9%88%E8%AF%B4%E5%A0%86%E6%8E%92%E5%BA%8F%E6%B2%A1%E6%9C%89%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E5%BF%AB/
 *
 *
 */

/***
 * ������ʱ�临�Ӷ�һ����Ϊ����O(nlogn)��
 * �ռ�O(1��
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
        //step 1:  ����󶥶�
        buildMaxHeap(array);

        //step2: �����Ѷ�Ԫ����ĩβԪ�� + �����ѽṹ
        for (int i = array.length - 1; i >= 1; i--) {
            ArrayUtils.exchangeElements(array, 0, i);  //���Ѷ�Ԫ����ĩβԪ�ؽ��н���
            ajustHeap(array,0, i);  //���¶Զѽ��е���
        }
    }

	//��ʼ������
	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = array.length / 2 - 1; //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
		for (int i = half; i >= 0; i--) {
			ajustHeap(array, i, array.length);
		}
	}


	/***
	 *  �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ� ���ϵ���
     *  ����һ: ����Ϊi�����ӵ������� (2*i+1);
     * ���ʶ�: ����Ϊi�����ӵ������� (2*i+2);
     * ������: ����Ϊi�ĸ����������� floor((i-1)/2);
	 * @param array
	 * @param heapSize  ������ѳ���
	 * @param index ��ǰԪ������
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









	//��������
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
