package ind.rozaydin.numbers.service;

import ind.rozaydin.numbers.exceptions.SolutionNotExistException;
import ind.rozaydin.numbers.model.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ind.rozaydin.numbers.util.RMath.cartesian;

public class SubsetSumCalculatorService {

  /**
   * Orders and counts the results of a cartesian operation turns [1,0,2] into [1,1,1] [1,1,1] into
   * [0,3,0]
   *
   * @param input
   * @return
   */
  public static int[] orderAndCount(int[] input, int depth) {
    int[] variableCount = new int[depth];
    for (int i = 0; i < input.length; i++) {
      variableCount[input[i]]++;
    }
    return variableCount;
  }

  public static boolean checkSolution(int[] solution, int[] elements, int target) {
    int sum = 0;
    for (int i = 0; i < solution.length; i++) {
      sum += elements[i] * solution[i];
    }
    // check if we hit target
    return sum == target;
  }

  public static int calculateTraverseCount(int target, int element) {
    return (target / element) + ((target % element) > 0 ? 1 : 0);
  }

  public static int[] calculateSolutionSpace(int[] set, int target) {
    List<Integer> filteredList =
        Arrays.stream(set)
            .filter(elem -> elem <= target)
            .sorted()
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

    if (filteredList.isEmpty()) {
      throw new SolutionNotExistException();
    }

    int minElement = filteredList.get(0);
    int maxElement = filteredList.get(filteredList.size() - 1);

    int maxTraverseCount = calculateTraverseCount(target, minElement);
    int minTraverseCount = calculateTraverseCount(target, maxElement);

    return new int[] {minTraverseCount, maxTraverseCount};
  }

  public static List<int[]> calculateSubsetSum(int target, int[] set) {

    int[] solutionSpace = calculateSolutionSpace(set, target);
    List<int[]> solutions = new ArrayList<>();

    // search problem space
    for (int i = solutionSpace[0]; i <= solutionSpace[1]; i++) {
      int[][] result = cartesian(set, i, SubsetSumCalculatorService::orderAndCount);
      Arrays.stream(result)
          .filter(solution -> checkSolution(solution, set, target))
          .map(Solution::new)
          .distinct()
          .map(Solution::getSolutionSet)
          .forEach(solutions::add);
    }
    // return solutions
    return solutions;
  }
}
