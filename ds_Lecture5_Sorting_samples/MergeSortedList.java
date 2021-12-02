package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class MergeSortedList {
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length+b.length];
		int j=0,i=0,k=0;
	    while(i<a.length && j<b.length && k<c.length) {
	    	if(a[i]<b[j]) {
				c[k]=a[i];
				i++;
				k++;
			}
			else if(a[i]>b[j]) {
				c[k]=b[j];
				j++;
				k++;
			}
			else if(a[i]==b[j]) {
				c[k]=a[i];
				c[k+1]=b[j];
				i++;
				j++;
				k=k+2;
			}
	    }
	    if(i!=a.length||j!=b.length) {
	    	while(i!=a.length) {
	    		c[k]=a[i];
	    		i++;
	    		k++;
	    	}
	    	while(j!=b.length) {
	    		c[k]=b[j];
	    		j++;
	    		k++;
	    	}
	    }
	    return c;
	}
	 public static void bucketSort(int[] a, int maxVal) {
	      int[] bucket=new int[maxVal+1];
	 
	      for (int i=0; i<a.length; i++) {
	         bucket[a[i]]++;
	      }
	 
	      int outPos=0;
	      for (int i=0; i<bucket.length; i++) {
	         for (int j=0; j<bucket[i]; j++) {
	            a[outPos++]=i;
	         }
	      }
	   }

	public static void main(String[] args) {
		int maxVal=5;
	      int maxVal2=12;
	      int[] data= {5,3,0,2,4,1,0,5,2,3,1,4};
	      int[] data2= {6,7,0,0,10,12,3,4,6,7,8};
	 
	      System.out.println("Before: " + Arrays.toString(data));
	      bucketSort(data,maxVal);
	      System.out.println("After:  " + Arrays.toString(data));
	      System.out.println("Before: " + Arrays.toString(data2));
	      bucketSort(data2,maxVal2);
	      System.out.println("After:  " + Arrays.toString(data2));
	      System.out.println(Arrays.toString(merge(data,data2)));

	}

}
