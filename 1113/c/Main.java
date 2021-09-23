import java.util.*;

public class Main {
  
  private static long solve(int n, int [] a) {
    int [][] xors = new int[n][n];
    for (int i = 0; i < n; i++) {
      int xor = 0;
      for (int j = i; j < n; j++) {
        xor = xor ^ a[j];
        xors[i][j] = xor;
      }
    }

    long count = 0;
    for (int r = 0; r < n; r++) {
      for (int l = 0; l <= r; l++) {
        int mid = (l+r-1)/2;
        if ( (r-l) >= 1 && (r-l+1)%2==0) {
          if (xors[l][mid] == xors[mid+1][r]) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String [] args) { 
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int [] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scanner.nextInt();
      }
      System.out.println(solve(n, a));
    }
  }
}
