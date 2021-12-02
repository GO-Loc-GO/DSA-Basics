package ds_Lecture5_Sorting_samples;

import java.util.*;

public class BucketSort{
 
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
   }
}