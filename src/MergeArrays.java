import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MergeArrays {

    public static int[] mergeSortArrays(int[] arrayLeft, int[] arrayRight) {
        int leftLength = arrayLeft.length;
        int rightLength = arrayRight.length;
        int resultLength = leftLength + rightLength;
        int[] result = new int[resultLength];
        int cursorLeft = 0;
        int cursorRight = 0;


        for (int cursor = 0; cursor < resultLength; cursor = cursor + 1) {

            if (cursorLeft >= leftLength) {
                result[cursor] = arrayRight[cursorRight];
                cursorRight += 1;
            } else if (cursorRight >= rightLength) {
                result[cursor] = arrayLeft[cursorLeft];
                cursorLeft += 1;
            } else if (arrayLeft[cursorLeft] < arrayRight[cursorRight]) {
                result[cursor] = arrayLeft[cursorLeft];
                cursorLeft += 1;
            } else {
                result[cursor] = arrayRight[cursorRight];
                cursorRight += 1;
            }

        }

        return result;
    }

    @Test
    public void testMergeSortArrays() {
        int[] res = MergeArrays.mergeSortArrays(new int[]{0, 2, 2}, new int[]{1, 3});
        Assert.assertArrayEquals(new int[]{0, 1, 2, 2, 3}, MergeArrays.mergeSortArrays(new int[]{0, 2, 2}, new int[]{1, 3}));
        Assert.assertArrayEquals(new int[]{0, 1, 3}, MergeArrays.mergeSortArrays(new int[]{0}, new int[]{1, 3}));
        Assert.assertArrayEquals(new int[]{0, 1, 3,4}, MergeArrays.mergeSortArrays(new int[]{0, 3,4}, new int[]{1}));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 2, 3, 5, 6, 7}, MergeArrays.mergeSortArrays(new int[]{0, 2, 2, 5, 6, 7}, new int[]{1, 3}));
        Assert.assertArrayEquals(new int[]{-3, -2, -1, -1, 0, 1, 1}, MergeArrays.mergeSortArrays(new int[]{-3, -2, -1, 0}, new int[]{-1, 1, 1}));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 2, 3, 5, 7, 8, 10, 10, 10, 10, 20}, MergeArrays.mergeSortArrays(new int[]{0, 2, 2, 10, 10, 20}, new int[]{1, 3, 5, 7, 8, 10, 10}));

    }


    public static int[] mergeArrays(int[] a1, int[] a2) {
        int a1Length = a1.length;
        int a2Length = a2.length;
        int[] result = new int[a1Length + a2Length];
        System.arraycopy(a1, 0, result, 0, a1Length);

        System.arraycopy(a2, 0, result, a1Length, a2Length);
        Arrays.sort(result);

        return result;
    }


    @Test
    public void testMergeArrays() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 2, 3}, MergeArrays.mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3}));
        Assert.assertArrayEquals(new int[]{0, 1, 3}, MergeArrays.mergeArrays(new int[]{0}, new int[]{1, 3}));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 2, 3, 5, 6, 7}, MergeArrays.mergeArrays(new int[]{0, 2, 2, 5, 6, 7}, new int[]{1, 3}));
        Assert.assertArrayEquals(new int[]{-3, -2, -1, -1, 0, 1, 1}, MergeArrays.mergeArrays(new int[]{-3, -2, -1, 0}, new int[]{-1, 1, 1}));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 2, 3, 5, 7, 8, 10, 10, 10, 10, 20}, MergeArrays.mergeArrays(new int[]{0, 2, 2, 10, 10, 20}, new int[]{1, 3, 5, 7, 8, 10, 10}));
    }
}
