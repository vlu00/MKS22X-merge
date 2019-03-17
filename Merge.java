import java.util.Random;
import java.io.*;
import java.util.*;

public class Merge {

  public static int[] createArray(int[] data, int lo, int hi) {
    int[] L = new int[hi-lo+1];
    int i = 0;
    while (hi > lo) {
      L[i] = data[lo];
      lo++;
    }
    return L;
  }

  public static int[] merge(int[] data, int lo, int divide, int hi) {
    int[] a = createArray(data, lo, divide);
    int[] b = createArray(data, divide+1, hi);

    //sorting
    int indexA = 0;
    int indexB = 0;
    int i = 0;
    int[] complete = new int[(a.length+b.length)];
    while (i < a.length+b.length) {
      if (indexA == a.length) {
        complete[i] = b[indexB];
        indexB++;
      }
      else if (indexB == b.length) {
        complete[i] = a[indexA];
        indexA++;
      }
      else if (a[indexA] < b[indexB]) {
        complete[i] = a[indexA];
        indexA++;
      }
      else {
        complete[i] = b[indexB];
        indexB++;
      }
      i++;
    }
    return complete;
  }

  public static void mergesort(int[]data){
    mergesort(data, 0, data.length-1);
  }

  public static void mergesort(int[]data, int lo, int hi){
    if (lo >= hi) {
      return;
    }
    mergesort(data, lo, lo+hi/2);
    mergesort(data, lo+hi/2+1, hi);
    merge(data, lo, lo+hi/2, hi);
  }

  public static void main(String[] args) {
    int[] A = new int[] {5, 8, 3, 0, 7, 6};
    int[] B = new int[] {5, 6};

    mergesort(A);
    System.out.println(Arrays.toString(A));
    //System.out.println(Arrays.toString(merge(B, A)));
  }
}
