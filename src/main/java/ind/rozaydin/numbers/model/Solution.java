package ind.rozaydin.numbers.model;

import java.util.Arrays;

public class Solution {

  private final int[] solutionSet;

  public Solution(int[] solutionSet) {
    this.solutionSet = solutionSet;
  }

  public int[] getSolutionSet() {
    return solutionSet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Solution)) return false;

    Solution solution = (Solution) o;

    return Arrays.equals(solutionSet, solution.solutionSet);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(solutionSet);
  }
}
