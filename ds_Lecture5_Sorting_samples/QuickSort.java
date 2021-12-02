package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class QuickSort {
	 public static void quickSort(int[] arr, int start, int end) {

	        if(start >= end) {
	            return;
	        }
	        // 1.  ������ָ�� low �� high �����ǵĳ�ʼֵ�ֱ�Ϊ���鿪ʼ���±� start������������±�end

	        int low = start;

	        int high = end;

	        // 2.  ����ֵΪ pivotKey

	        int pivotKey = arr[start];

	        // 5. �ظ�ǰ����������3��4����ֱ�� low == high

	        while (low<high) {

	            // 3. ���ȴ� high ��ָλ����ǰ��������������һ��С�� pivotKey �� ֵ��Ȼ�����ֵ��  pivotKey ���ཻ��

	            while (low<high && arr[high]>=pivotKey) {

	                high--;

	            }

	            int temp1 = arr[low];

	            arr[low] = arr[high];

	            arr[high] = temp1;

	            // 4. �� low ��ָλ�������������������һ������ pivotKey �� ֵ��Ȼ�����ֵ��  pivotKey ���ཻ����

	            while (low<high && arr[low]<=pivotKey) {

	                low++;

	            }

	            temp1 = arr[low];

	            arr[low] = arr[high];

	            arr[high] = temp1;

	        }

	        // �� С������ֵ���ǲ�������ֵ ���п���

	        quickSort(arr, start, low-1);

	        // �� ��������ֵ���ǲ�������ֵ ���п���

	        quickSort(arr, low+1, end);

	    }

	public static void main(String[] args) {
		int[] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
		 
	      System.out.println("Before: " + Arrays.toString(data));
	      quickSort(data,0,data.length-1);
	      System.out.println("After:  " + Arrays.toString(data));

	}

}
