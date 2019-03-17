import java.io.*;
import java.util.*;

public class Merge {

  public static void merge(int[] data, int lo, int divide, int hi) {
    int j = lo;
    int k = divide+1;
    int i = 0;

    int[] a = new int[divide-lo+1];
    while (j < divide+1) {
      a[i] = data[j];
      i++;
      j++;
    }

    i = 0;
    int[] b = new int [hi-divide];
    while (k < hi+1) {
      b[i] = data[k];
      i++;
      k++;
    }
    //System.out.println(Arrays.toString(a));
    //System.out.println(Arrays.toString(b));

    //sorting
    int indexA = 0;
    int indexB = 0;
    while (lo < a.length+b.length) {
      if (indexA == a.length) {
        data[lo] = b[indexB];
        indexB++;
      }
      else if (indexB == b.length) {
        data[lo] = a[indexA];
        indexA++;
      }
      else if (a[indexA] < b[indexB]) {
        data[lo] = a[indexA];
        indexA++;
      }
      else {
        data[lo] = b[indexB];
        indexB++;
      }
      lo++;
    }
  }

  public static void mergesort(int[]data){
    mergesort(data, 0, data.length-1);
  }

  public static void mergesort(int[]data, int lo, int hi){
    if (lo >= hi) {
      return;
    }
    int divide = (lo+hi)/2;
    mergesort(data, lo, divide);
    mergesort(data, divide+1, hi);
    merge(data, lo, divide, hi);
  }

  public static void main(String[] args) {
    //int[] A = new int[] {0, 3, 5, 6, 7, 8};
    int[] B = new int[] {5, 8, 0, 1, 3, 6};

    mergesort(B);
    System.out.println(Arrays.toString(B));
    //merge(A, 0, 2, 5);
    //System.out.println(A);
  }
}
