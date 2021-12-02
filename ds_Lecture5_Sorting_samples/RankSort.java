package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class RankSort {
	public static void rankSort (int b[] , int n ){
		int[] c = new int[b.length];
		int k,j;
		for ( k = 0; k < n; k++ ){
			int rank=0;
		  for ( j = 0; j < n; j++ ){
		    if ( b[k] > b[j]){ 
			rank++;
		    }
		  }
		  if(c[rank] == b[k]) {
		    c[rank+1] = b[k];
		  }else {
			  c[rank] = b[k];
		  }
		}
		for(int i=0;i<b.length;i++) {
			b[i]=c[i];
		}
	}
    
	public static void main(String[] args) {
	      int[] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
	 
	      System.out.println("Before: " + Arrays.toString(data));
	      rankSort(data,data.length);
	      System.out.println("After:  " + Arrays.toString(data));
	   }
}
