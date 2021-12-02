package ds_labs;

import java.util.Arrays;

public class Lab3 {
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
	public static void large(int s[]) {
		int max=s[0],i;
		int[] result= new int[2];
		for(i=0;i<s.length;i++) {
			if(s[i]>max) {
				max=s[i];
			}
		}
		bucketSort(s,max);
	    result[0]=max;
	    i=i-1;
	    result[1]=s[i];
	    while(result[1]==max){
	    	result[1]=s[i];
	    	i--;
	    }
	    System.out.println(Arrays.toString(result));
	}
	public static int[] reverse(int s[]) {
		int[] temp = new int[s.length];
		int i,j=s.length-1;
		for(i=0;i<s.length;i++) {
			temp[i]=s[j];
			j--;
		}
		return temp;
	}

	public static void main(String[] args) {
	      int[] data= {5,3,0,2,4,1,0,5,2,3,1,4};
	      data=reverse(data);
	      System.out.println("Reversed: " + Arrays.toString(data));
	      large(data);
	      
	}

}
