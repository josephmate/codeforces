import java.util.*;

public class Main {
  
  private static void query(
          int [] initialValues,
          int a_x,
          int steps
  ) {
    int [] current = Arrays.copyOf(initialValues, initialValues.length);
    for (int i = 0; i < steps; i++) {
      Map<Integer, Integer> counts = new HashMap<>();
      for (int j = 0; j < current.length; j++) {
        counts.put(current[j], counts.getOrDefault(current[j], 0) + 1);
      }

      int [] prev = current;
      current = new int[initialValues.length];
      for (int j = 0; j < current.length; j++) {
        current[j] = counts.getOrDefault(prev[j], 0);
      }
    }
    System.out.println(current[a_x]);
  }

  public static void main(String [] args) { 
    try (Scanner scanner = new Scanner(System.in)) {
      int numTests = scanner.nextInt();
      for (int i = 0; i < numTests; i++) {
        int size = scanner.nextInt();
        int [] values = new int[size];
        for (int j = 0; j < size; j++) {
          values[j] = scanner.nextInt();
        }
        int numQueries = scanner.nextInt();
        for (int j = 0; j < numQueries; j++) {
          int a_x = scanner.nextInt();
          int step = scanner.nextInt();
          query(values, a_x-1, step);
        }
      }
    }
  }
}
