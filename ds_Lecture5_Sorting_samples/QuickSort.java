package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class QuickSort {
	 public static void quickSort(int[] arr, int start, int end) {

	        if(start >= end) {
	            return;
	        }
	        // 1.  设两个指针 low 和 high ，他们的初始值分别为数组开始的下标 start，数组结束的下标end

	        int low = start;

	        int high = end;

	        // 2.  枢轴值为 pivotKey

	        int pivotKey = arr[start];

	        // 5. 重复前两步操作（3，4），直至 low == high

	        while (low<high) {

	            // 3. 首先从 high 所指位置向前搜索，搜索到第一个小于 pivotKey 的 值，然后将这个值和  pivotKey 互相交换

	            while (low<high && arr[high]>=pivotKey) {

	                high--;

	            }

	            int temp1 = arr[low];

	            arr[low] = arr[high];

	            arr[high] = temp1;

	            // 4. 从 low 所指位置向后搜索，搜索到第一个大于 pivotKey 的 值，然后将这个值和  pivotKey 互相交换。

	            while (low<high && arr[low]<=pivotKey) {

	                low++;

	            }

	            temp1 = arr[low];

	            arr[low] = arr[high];

	            arr[high] = temp1;

	        }

	        // 对 小于枢轴值的那部分数组值 进行快排

	        quickSort(arr, start, low-1);

	        // 对 大于枢轴值的那部分数组值 进行快排

	        quickSort(arr, low+1, end);

	    }

	public static void main(String[] args) {
		int[] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
		 
	      System.out.println("Before: " + Arrays.toString(data));
	      quickSort(data,0,data.length-1);
	      System.out.println("After:  " + Arrays.toString(data));

	}

}
