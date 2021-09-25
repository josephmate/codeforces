import java.util.*;

public class Main {
  
  private static long solve(int n, int [] a) {
    long count = 0;
    for (int i = 0; i < n; i++) {
      int xor = 0;
      for (int j = i; j < n; j++) {
        xor = xor ^ a[j];
        // dynamic programming method would use 38GB of memory!
        // realized that if a ^ b ^ c = d ^ e ^ f
        // then a ^ b ^ c ^ d ^ e ^ f = 0 !
        // so we just need to count the 0s and the dynamic programming is no longer necessary.
        if (  j-i >=1
              && (j-i + 1)%2 == 0
              && xor == 0
        ) {
          count++;
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
