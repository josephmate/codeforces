import java.util.*;

public class Main {
  
  private static int query(
          StepTracker stepTracker,
          int a_x,
          int steps
  ) {
    if (stepTracker.repeated) {
      return stepTracker.current[a_x];
    }

    for (int i = stepTracker.step; i < steps; i++) {
      Map<Integer, Integer> counts = new HashMap<>();
      for (int j = 0; j < stepTracker.current.length; j++) {
        counts.put(stepTracker.current[j], counts.getOrDefault(stepTracker.current[j], 0) + 1);
      }

      int [] prev = stepTracker.current;
      stepTracker.current = new int[stepTracker.current.length];
      for (int j = 0; j < stepTracker.current.length; j++) {
        stepTracker.current[j] = counts.getOrDefault(prev[j], 0);
      }
      stepTracker.step++;

      // check if prev is the same as current. if so then the result will never change
      boolean same = true;
      for (int j = 0; j < stepTracker.current.length; j++) {
        if (prev[j] != stepTracker.current[j]) {
          same = false;
        }
      }
      if (same) {
        stepTracker.repeated = true;
        return stepTracker.current[a_x];
      }
    }
    return stepTracker.current[a_x];
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

        // process the queries in the order of steps
        List<Query> queries = new ArrayList<>(numQueries);
        for (int j = 0; j < numQueries; j++) {
          Query query = new Query();
          query.posn = j;
          query.a_x = scanner.nextInt();
          query.steps = scanner.nextInt();
          queries.add(query);
        }
        Collections.sort(queries, Comparator.comparing(Query::getSteps));
        StepTracker stepTracker = new StepTracker();
        stepTracker.current = values;
        for (Query query : queries) {
          query.result = query(stepTracker, query.a_x-1, query.steps);
        }

        // output in the order of input
        Collections.sort(queries, Comparator.comparing(Query::getPosn));
        for (Query query : queries) {
          System.out.println(query.result);
        }
      }
    }
  }

  private static class StepTracker {
    int step = 0;
    boolean repeated = false;
    int [] current;
  }

  private static class Query {
    int posn;
    int a_x;
    int steps;
    int result;

    public int getSteps() {
      return steps;
    }

    public int getPosn() {
      return posn;
    }
  }
}
