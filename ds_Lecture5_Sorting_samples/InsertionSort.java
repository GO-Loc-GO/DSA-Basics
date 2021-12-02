package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int[] k, int n){
		int j = 0;
		  while ( j < n ) {
		  int i = j ;
		  while ( i > 0 && k[i] < k[i-1]) {
		    int temp = k [i];
		    k[i] = k [i -1];
		    k[i -1] = temp;
		    i = i - 1;
		  }
		  j = j + 1;
	    }
	}
	public static void main(String[] args) {
		int[] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
		 
	      System.out.println("Before: " + Arrays.toString(data));
	      insertionSort(data,data.length);
	      System.out.println("After:  " + Arrays.toString(data));
	}

}
