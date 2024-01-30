package exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Jan30Test {
    private static Jan30 objUnderTest = new Jan30();

    // tests t00 - t03 for cumulativeSum
    @Test
    public void t00() {
        //edge cases
        int[] result1 = objUnderTest.cumulativeSum(null);
        assertArrayEquals(new int[]{}, result1);

        int[] result2 = objUnderTest.cumulativeSum(new int[]{});
        assertArrayEquals(new int[]{}, result2);
    }
    @Test
    public void t01() {
        int[] input = {1};
        int[] result = objUnderTest.cumulativeSum(input);
        int[] expected = {1};
        assertArrayEquals(expected, result);
    }
    @Test
    public void t02() {
        int[] input = {1, 1};
        int[] result = objUnderTest.cumulativeSum(input);
        int[] expected = {1, 2};
        assertArrayEquals(expected, result);
    }
    @Test
    public void t03() {
        int[] input = {1, 23, 3, 4, 57};
        int[] result = objUnderTest.cumulativeSum(input);
        int[] expected = {1, 24, 27, 31, 88};
        assertArrayEquals(expected, result);
    }

    // tests t0-t9 for threeSum
    @Test
    public void t0() {
        //edge cases
        int[] result1 = objUnderTest.threeSum(null);
        assertArrayEquals(new int[]{}, result1);

        int[] result2 = objUnderTest.threeSum(new int[]{});
        assertArrayEquals(new int[]{}, result1);
    }
    @Test
    public void t1() {
        int[] input = {11};
        int[] result = objUnderTest.threeSum(input);
        int[] expected = {11};
        assertArrayEquals(expected, result);
    }
    @Test
    public void t2() {
        int[] input = {11, 2};
        int[] result = objUnderTest.threeSum(input);
        int[] expected = {13};
        assertArrayEquals(expected, result);
    }
    @Test
    public void t3() {
        int[] input = {11, 2, 13};
        int[] result = objUnderTest.threeSum(input);
        int[] expected = {26};
        assertArrayEquals(expected, result);
    }
    @Test
    public void t4() {
        int[] input = {11, 2, 13, 4, 54, 6, 7};
        int[] result = objUnderTest.threeSum(input);
        int[] expected = {26, 19, 71, 64, 67};
        assertArrayEquals(expected, result);
    }

}