package ind.rozaydin.numbers.service;

import ind.rozaydin.numbers.exceptions.SolutionNotExistException;
import org.junit.Assert;
import org.junit.Test;

public class SubsetSumCalculatorServiceTest {

  @Test(expected = SolutionNotExistException.class)
  public void should_throw_solution_not_exist_exception() {

    int[] set = new int[] {4, 5, 6};
    int target = 1;

    SubsetSumCalculatorService.calculateSolutionSpace(set, target);
  }

  @Test
  public void should_correclty_calculate_solution_space() {

    int[] set = new int[] {1, 2, 3};
    int target = 5;

    int[] solutionSpace = SubsetSumCalculatorService.calculateSolutionSpace(set, target);
    Assert.assertArrayEquals(new int[] {2, 5}, solutionSpace);
  }

  @Test
  public void should_calculate_solution_space_() {

    int[] set = new int[] {1, 2, 3};
    int target = 2;

    int[] solutionSpace = SubsetSumCalculatorService.calculateSolutionSpace(set, target);
    Assert.assertArrayEquals(new int[] {1, 2}, solutionSpace);
  }
}
