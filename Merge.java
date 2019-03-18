import java.io.*;
import java.util.*;

public class Merge {

  public static void merge(int[] data, int lo, int divide, int hi) {
    System.out.println(Arrays.toString(data));
    System.out.println("lo " + lo + " d " + divide + " hi " + hi);

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
    //System.out.println("a " + Arrays.toString(a));
    //System.out.println("b" + Arrays.toString(b));

    //sorting
    int indexA = 0;
    int indexB = 0;
    int h = 0;
    while (h < a.length+b.length) {
      //System.out.println(lo);
      //System.out.println(indexA);
      //System.out.println(indexB);
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
      h++;
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
    int[] B = new int[100];
    for (int i = 0; i < 100; i++) {
      B[i] = 100-i;
    }
    mergesort(B);
    System.out.println(Arrays.toString(B));
    //merge(A, 0, 2, 5);
    //System.out.println(A);
  }
}
