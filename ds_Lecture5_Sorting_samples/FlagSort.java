package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class FlagSort {
	public static void swap(int f[], int i, int j) {
		int temp=f[i];
		f[i]=f[j];
		f[j]=temp;
	}
	public static void flagSort(int f[], int n) {
		int i = 0;
		int j = 0;
		int k = n;
		while(j != k) {
			if(f[j]==1) {
				swap(f,i,j);
				i++;
				j++;
			}else if(f[j]==0) {
				j++;
			}else if(f[j]==2) {
				swap(f,j,k-1);
				k--;
			}
		}
	}
	public static void main(String[] args) {
		int[] f= {0,0,0,2,2,1,2,0,0,1};
		System.out.println("Before: " + Arrays.toString(f));
	    flagSort(f,f.length);
	    System.out.println("After:  " + Arrays.toString(f));

	}

}
