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
    int indexA = 0; //index of left list being checked
    int indexB = 0; //index of right list being checked
    int counter = 0;

    while (counter <= hi-lo) {
      if (indexA > divide-lo) {
        data[lo+counter] = temp[divide+indexB+1]; //if one "list" is empty
        indexB++; //keep adding ints of remaining list
      }
      else if (indexB >= hi - divide) {
        data[lo+counter] = temp[lo+indexA];
        indexA++;
      }
      else if (temp[lo+indexA] < temp[divide+indexB+1]) { //checking which next element is least
        data[lo+counter] = temp[lo + indexA]; //that gets added to data
        indexA++;
      }
      else {
        data[lo+counter] = temp[divide+indexB+1];
        indexB++;
      }
      counter++;
    }
  }

  public static void mergesort(int[]data){
    int[] temp = createArray(data, 0, data.length-1); //duplicate list
    mergesort(data, temp, 0, data.length-1);
  }

  public static void mergesort(int[]data, int[]temp, int lo, int hi){
    if (hi-lo+1 < 40) {
      insertionsort(data, lo, hi); //if data is small enough, use insertionsort (good for many duplicates)
    }
    else {
      int divide = (lo+hi)/2;
      mergesort(temp, data, lo, divide);
      mergesort(temp, data, divide+1, hi);
      merge(data, temp, lo, divide, hi); 
    }
  }
}
