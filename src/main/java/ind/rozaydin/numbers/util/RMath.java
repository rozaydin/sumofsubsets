package ind.rozaydin.numbers.util;

import java.util.function.BiFunction;

public class RMath {

    public static int[][] cartesian(int[] input, int depth) {

        int len = input.length;
        int gotoLimit = (int) Math.pow(len, depth);
        int[][] results = new int[gotoLimit][len];

        for (int i = 0; i < Math.pow(len, depth); i++) {
            results[i] = new int[depth];
            // calculate elements
            for (int j = 0; j < depth; j++) {
                int value = (i / (int) Math.pow(len, j)) % len;
                results[i][depth - j - 1] = value;
            }
        }
        return results;
    }

    public static int[][] cartesian(
            int[] input, int depth, BiFunction<int[], Integer, int[]> transform) {

        int len = input.length;
        int gotoLimit = (int) Math.pow(len, depth);
        int[][] results = new int[gotoLimit][len];

        for (int i = 0; i < Math.pow(len, depth); i++) {
            results[i] = new int[depth];
            // calculate elements
            for (int j = 0; j < depth; j++) {
                int value = (i / (int) Math.pow(len, j)) % len;
                results[i][depth - j - 1] = value;
            }
            // transform result
            results[i] = transform.apply(results[i], len);
        }
        return results;
    }

}
