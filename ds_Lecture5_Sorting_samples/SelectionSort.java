package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class SelectionSort {
	public static void selectionSort (int f[] , int n ) {
		int i , j ;
		for (i = 0; i < n; i++) {
		  int k = i ;
		  for (j = i + 1; j < n; j++) {
		    if (f[j] < f[k]){
		    k = j;
		    }
		  }
		  int temp = f[i];
		  f[i] = f[k];
		  f[k] = temp;
		}
	}
	 
	public static void main(String[] args) {
	      int[] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
	 
	      System.out.println("Before: " + Arrays.toString(data));
	      selectionSort(data,data.length);
	      System.out.println("After:  " + Arrays.toString(data));
	   }

}
