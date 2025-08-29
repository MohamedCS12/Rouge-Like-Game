package game.utils;

import java.util.Random;

/**
 * A random number generator.
 */
public class RandomNumberGenerator {

    /**
     * Generates a random integer within the specified upper bound.
     *
     * @param bound the upper bound (exclusive) for the random number
     * @return a random integer
     */
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    /**
     * Generates a random integer within the specified lower and upper bounds.
     *
     * @param lowerBound the lower bound (inclusive) for the random number
     * @param upperBound the upper bound (inclusive) for the random number
     * @return a random integer
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
