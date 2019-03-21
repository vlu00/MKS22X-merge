import java.io.*;
import java.util.*;

public class Merge {

  public static void insertionsort(int[] data, int lo, int hi) {
    if (hi-lo+1 > 1) { //if length is 0 or 1, data remains the same
      int counter = lo;
      while (counter < hi) {
        int x = data[counter+1];
        int index = counter+1;
        for (int n = counter+1; n != lo && data[n-1] > x; n--) {
          data[n] = data[n-1];
          index--;
        }
        data[index] = x;
        counter++;
      }
    }
  }

  public static int[] createArray(int[] data, int lo, int hi) {
    int[] L = new int[hi-lo+1];
    int i = 0;
    while (hi >= lo) {
      L[i] = data[lo];
      i++;
      lo++;
    }
    return L;
  }

  public static void merge(int[] data, int[] temp, int lo, int divide, int hi) {
    System.out.println("temp " + Arrays.toString(temp));
    System.out.println("data " + Arrays.toString(data));

    int indexA = 0;
    int indexB = 0;
    int counter = 0;
    int index = lo;
    while (counter <= hi-lo) {
      //System.out.println("data: " + Arrays.toString(data));
      //System.out.println("temp: " + Arrays.toString(temp));

      if (indexA > divide-lo) {
        data[index] = temp[divide+indexB+1];
        indexB++;
      }
      else if (indexB >= hi - divide) {
        data[index] = temp[lo+indexA];
        indexA++;
      }
      else if (data[lo+indexA] < temp[divide+indexB+1]) {
        data[index] = temp[lo + indexA];
        indexA++;
      }
      else {
        data[index] = temp[divide+indexB+1];
        indexB++;
      }
      index++;
      counter++;
    }
    System.out.println("adata " + Arrays.toString(data));

    for (int i = 0; i < data.length; i++) {
      //System.out.println(data[i]);
        temp[i] = data[i];
     }

     System.out.println("atemp " + Arrays.toString(temp));

  }

  public static void mergesort(int[]data){
    int[] temp = createArray(data, 0, data.length-1);
    mergesort(data, temp, 0, data.length-1);
    //mergesort(data, 0, data.length-1);
  }

  public static void mergesort(int[]data, int[]temp, int lo, int hi){
    if (lo >= hi) {
      return;
    }
    int divide = (lo+hi)/2;
    /*
    mergesort(data, lo, divide);
    mergesort(data, divide+1, hi);
    merge(data, lo, divide, hi);
    */
    mergesort(temp, data, lo, divide);
    mergesort(data, temp, divide+1, hi);
    merge(data, temp, lo, divide, hi);

  }
/*
  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=4){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
*/
  public static void main(String[] args) {
    int[] A = new int[] {4, 3, 2, 1};
    //int[] B = new int[100];
    //for (int i = 0; i < 100; i++) {
    //  B[i] = 100-i;
    //}
    mergesort(A);
    System.out.println(Arrays.toString(A));
    //merge(A, 0, 2, 5);
    //System.out.println(A);
  }
}
/*
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

  //sorting
  int indexA = 0;
  int indexB = 0;
  int h = 0;
  while (h < a.length+b.length) {
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
*/
