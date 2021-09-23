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
    for (int r = 1; r < n; r++) {
      for (int l = 1; l <= r; l++) {
        int mid = (l+r-1)/2;
        if ( (r-l) >= 2 && (r-l+1)%2==0
            && mid + 1 < n) {
          int rIdx = r - 1;
          int lIdx = l - 1;
          int midIdx = mid - 1;
          System.out.println(String.format("l=%d r=%d mid=%d", l , r , mid));
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
