import java.util.*;

public class Main {
  
  private static void solve(String s) {
    for (char i = 'a'; i <= 'z'; i++) {
      if (s.indexOf(i) >= 0) {
        int indexOfChar = s.indexOf(i);
        System.out.print(i);
        System.out.print(" ");
        System.out.println(
                (indexOfChar >= 1 ? s.substring(0, indexOfChar-1) : "")
                + (indexOfChar <= s.length() - 2 ? s.substring(indexOfChar+1) : "")
        );
        return;
      }
    }
  }

  public static void main(String [] args) { 
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      for (int i = 0; i < n; i++) {
        solve(scanner.next());
      }
    }
  }
}
