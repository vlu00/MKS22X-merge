import java.io.*;
import java.util.*;

public class Merge {

  public static void merge(int[] data, int lo, int divide, int hi) {

    int[] a = new int[divide-lo+1];
    for (int j = 0; j < divide-lo+1; j++) {
      a[j] = data[lo+j];
    }

    int[] b = new int [hi-divide];
    for (int k = 0; k < hi-divide; k++) {
      b[k] = data[divide+k+1];
    }

    //sorting
    int indexA = 0;
    int indexB = 0;
    //sorts until one or both list(s) becomes empty
    while (indexA < a.length && indexB < b.length) {

      if (a[indexA] < b[indexB]) {
        data[lo] = a[indexA];
        indexA++;
      }
      else {
        data[lo] = b[indexB];
        indexB++;
      }
      lo++;
    }
    //if one list is empty, fill in data with the other
    while (indexB < b.length) {
      data[lo] = b[indexB];
      indexB++;
      lo++;
    }
    while (indexA < a.length) {
      data[lo] = a[indexA];
      indexA++;
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

/*
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
  */
}
