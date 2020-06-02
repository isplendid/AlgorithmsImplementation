package com.xu.leetcode.sort;

public class Sorts {
	public static void insertSort(int array[])
	{
		for(int i=1;i<array.length;i++)
		{
			int j=i-1;
			int key=array[i];
			while(j>=0&&array[j]>key)
			{
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=key;
			print(array);
		}
		
		
	}
	public static void bubbleSort(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=a.length-1;j>i;j--)
			{
				if(a[j]<a[j-1])
				{
					int temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
				
			}
			print(a);
		}
	}
	public static void selectSort(int a[])
	{
		for(int i=0;i<a.length-1;i++)
		{
			int min=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[min]>a[j])
					min=j;
			}
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
			print(a);
		}
		
	}
	public static void mergeSort(int a[],int start,int end)
	{
		int mid=(start+end)/2;
		if(start<end)
		{
			
			mergeSort(a,start,mid);
			mergeSort(a,mid+1,end);
			merge(a,start,mid,end);
			print(a);
		}
	}
	public static void merge(int[] a, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];  
        int i = start;// 左指针  
        int j = mid + 1;// 右指针  
        int k = 0;  
  
        // 把较小的数先移到新数组中  
        while (i <= mid && j <= end) {  
            if (a[i] < a[j]) {  
                temp[k++] = a[i++];  
            } else {  
                temp[k++] = a[j++];  
            }  
        }  
  
        // 把左边剩余的数移入数组  
        while (i <= mid) {  
            temp[k++] = a[i++];  
        }  
  
        // 把右边边剩余的数移入数组  
        while (j <= end) {  
            temp[k++] = a[j++];  
        }  
  
        // 把新数组中的数覆盖nums数组  
        for (int k2 = 0; k2 < temp.length; k2++) {  
            a[k2 + start] = temp[k2];  
        }  
		
	}
    public static void quickSort(int[] list,int left,int right)
    {
    	if(left >= right)
        {
            return;
        }
    	int first=left;
    	int last=right;
    	int key=list[left];

    	while(first<last)
    	{
    		while(first<last&&list[last]>=key)
    		{
    			last--;
    		}
    			
    		list[first]=list[last];
    		while(first<last&&list[first]<=key)
    		{
    			first++;
    		}
    		list[last]=list[first];
    	}
    	list[first]=key;
    	print(list);
    	quickSort(list,left,first-1);
    	quickSort(list,first+1,right);
    }
    
    
    
    
    
    
    
    
    
    
    
    /*
     * 堆排序*/
	public static void heapSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			createMaxdHeap(data, data.length - 1 - i);
			swap(data, 0, data.length - 1 - i);
		}
	}
	public static void createMaxdHeap(int[] data, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// 保存当前正在判断的节点
			int k = i;
			// 若当前节点的子节点存在
			while (2 * k + 1 <= lastIndex)
			{
				// biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) 
				{
					// 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
					if (data[biggerIndex] < data[biggerIndex + 1]) 
					{
						// 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
						biggerIndex++;
					}
				}
				if (data[k] < data[biggerIndex]) 
				{
					// 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
					swap(data, k, biggerIndex);
					k = biggerIndex;
				}
				else 
				{
					break;
				}
			}
		}
		print(data);
	}
    public static void print( int array[])
	{
		for(int i:array)
		{
			System.out.print("\t");
			System.out.print(i);
		}
		System.out.println();
	}
    public static void swap(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	public static void main(String args[])
	{
		int[]a={1,2,3,4,5,6,7,8};
		print(a);
		Sorts.quickSort(a, 0,a.length-1);
	}

}
