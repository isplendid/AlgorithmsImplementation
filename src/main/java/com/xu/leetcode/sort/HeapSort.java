package com.xu.leetcode.sort;

class ArrayUtils{
	public static void printArray(int[] array){
		System.out.print("{");
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]);
			if(i<array.length - 1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	
	public static void exchangeElements(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}

public class HeapSort {
public static void main(String[] args) {
	int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
	System.out.println("Before heap: ");
	ArrayUtils.printArray(array);
	
	heapSort(array);
	
	System.out.println("After heap sort: ");
	ArrayUtils.printArray(array);
}

private static  void heapSort(int[] array) {
	if(array == null || array.length == 1){
		return;
	}
	buildMaxHeap(array);
	
	for(int i = array.length - 1; i >= 1; i--){
		ArrayUtils.exchangeElements(array, 0, i);
		
		heapAdjust(array, i,0);
	}
}

private static void heapAdjust(int[] array, int heapSize, int index) {
	int left = index*2 +1;  //index娑撶儤鐗撮懞鍌滃仯閻ㄥ嫬鍙剧�鐐扮秴缂冿拷
    int right = index*2 +2;
    
    int largest = index;
    if(left < heapSize && array[left] > array[index]){
    	largest = left;
    }
    
    if(right < heapSize && array[right] > array[largest]){
    	largest = right;
    }
    
    if(index != largest){
    	ArrayUtils.exchangeElements(array, index, largest);
    	
    	heapAdjust(array, heapSize,largest);
    }
	
	
}

//瀵ゅ搫鍨垫慨瀣  ---婢堆囥�閸拷--
private static void buildMaxHeap(int[] array) {
    if(array == null || array.length <=1 ){
    	return;
    }
    
    int half = array.length/2;
    for(int i = half; i>=0; i--){
    	heapAdjust(array, array.length,i);
    }
    	
}	
    
    
  //调整最大堆~~
    public void heapify(int[]  arr, int index, int heapSize){
    	int left = index * 2 + 1;
    	int right = index * 2 + 2;
    	int largest = index;
    	
    	while(left < heapSize){
    		if(arr[left]>arr[index]){
    			largest = left;
    		}
    		
    		if(right <heapSize && arr[right]>arr[largest]){
    			largest = right;
    		}
    		
    		if(largest != index){
    			swap(arr, index, largest);
    		}else{
    			break;
    		}
    		index = largest;
    		left = index*2 +1;
    		right = index *2 +2;
    	}
    }
    
    
 private   void swap(int[] arr, int parent, int index) {
    	int tmp = arr[parent];
    	arr[parent] = arr[index];
    	arr[index] = tmp;
    	
    }



}
