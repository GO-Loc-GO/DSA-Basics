package ds_Project1;

import java.util.Arrays;

public class insertion {
	public static void swap1(int f[], int i, int j) {		//to swap the elements in a 1D array
		int temp=f[i];
		f[i]=f[j];
		f[j]=temp;
	}
	public static void swap2(int f[][], int i, int j) {		//to swap the rows in a multidimensional array
		int temp1=f[i][0];
		int temp2=f[i][1];
		f[i][0]=f[j][0];
		f[i][1]=f[j][1];
		f[j][0]=temp1;
		f[j][1]=temp2;
	}
	public static void insertionSort(int f[]) {
		int i,j=0;
		for(i=1;i<f.length;i++) {
			j=i;
			while(j>0 && f[j]<f[j-1]) {
				swap1(f,j,j-1);
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		int i,j;
		int[] testA = {1, 62, 81, 0, 23, 55, 76, 87, 20, 54, 65, 76, 1};
		int[][] testB = {{71, 2},{64, 8},{31, 56}, {98, 1}, {3, 6}, {59, 837}, {49, 58}, {61, 8}};
		//display the original arrays
		System.out.println("testA before sorting: {" + Arrays.toString(testA)+"}");
        System.out.print("testB before sorting: {");
		for(i=0;i<testB.length;i++) {
			System.out.print(Arrays.toString(testB[i]));
			if(i!=testB.length-1) {
				System.out.print(',');
			}else {
				System.out.print('}');
			}
		}
		
		//for testA
		insertionSort(testA);
		System.out.println("\ntestA after insertion sort: {" + Arrays.toString(testA)+"}");
		
		
		//for testB
		int[] temp = new int[testB.length];
        for(i=0;i<testB.length;i++) {             //storing the first element of each row into the template array
			temp[i]=testB[i][0];
		}
	    
		insertionSort(temp);   //sort the template array
		for(i=0;i<testB.length;i++) {
			for(j=0;j<testB.length;j++) {         //swap the rows according to the sorted template array
				if(temp[j]==testB[i][0]) {
					swap2(testB,j,i);
				}
			}
		}
		
		
		System.out.print("testB after insertion sort: {");		//print the results of testB
		for(i=0;i<testB.length;i++) {
			System.out.print(Arrays.toString(testB[i]));
			if(i!=testB.length-1) {
				System.out.print(',');
			}else {
				System.out.print('}');
			}
		}
	}      
		
}
