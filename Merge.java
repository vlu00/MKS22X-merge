import java.util.Random;
import java.io.*;
import java.util.*;

public class Merge {
  public static int[] merge(int[] a, int [] b) {
    int indexA = 0;
    int indexB = 0;
    int i = 0;
    int[] complete = new int[(a.length+b.length)];
    while (i < a.length+b.length) {
      //if (a.length)
      if (a[indexA] < b[indexB]) {
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

  public static void main(String[] args) {
    int[] A = new int[] {3};
    int[] B = new int[] {5};

    //int[] test1 = merge(A, B);
    System.out.println(Arrays.toString(merge(A, B)));
    //int[] test2 = merge(B, A);
    System.out.println(Arrays.toString(merge(B, A)));
  }
}
