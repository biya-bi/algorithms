package org.rainbow.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    void sort_ArrayIsGiven_ReturnSortedArray() {
        int[] arr = { 5, 4, 3, 2, 1, 5, 4, 3, 2, 1 };

        int[] result = MergeSort.sort(arr);

        assertArrayEquals(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, result);
    }

    @Test
    void sort_ArrayAndIndicesAreGiven_ReturnSortedArray() {
        int[] arr = { 200, 50, 75, 51, 16, 15, 8, 14, 13, 10, 25, 8 };

        int[] result = MergeSort.sort(arr, 0, arr.length - 1);

        assertArrayEquals(new int[] { 8, 8, 10, 13, 14, 15, 16, 25, 50, 51, 75, 200 }, result);
    }

    @Test
    void merge_Arr1IsNull_ReturnArr2() {
        int[] arr1 = null;
        int[] arr2 = { 1 };

        int[] result = MergeSort.merge(arr1, arr2);

        assertSame(arr2, result);
    }

    @Test
    void merge_Arr1IsEmpty_ReturnArr2() {
        int[] arr1 = new int[0];
        int[] arr2 = { 1 };

        int[] result = MergeSort.merge(arr1, arr2);

        assertSame(arr2, result);
    }

    @Test
    void merge_Arr2IsNull_ReturnArr1() {
        int[] arr1 = { 1 };
        int[] arr2 = null;

        int[] result = MergeSort.merge(arr1, arr2);

        assertSame(arr1, result);
    }

    @Test
    void merge_Arr2IsEmpty_ReturnArr1() {
        int[] arr1 = { 1 };
        int[] arr2 = new int[0];

        int[] result = MergeSort.merge(arr1, arr2);

        assertSame(arr1, result);
    }

    @Test
    void merge_Arr1AndArr2HaveSameLength_ReturnMergedArray() {
        int[] arr1 = { 1, 2 };
        int[] arr2 = { 3, 4 };

        int[] result = MergeSort.merge(arr1, arr2);

        assertArrayEquals(new int[] { 1, 2, 3, 4 }, result);
    }

    @Test
    void merge_Arr1IsShorterThanArr2_ReturnMergedArray() {
        int[] arr1 = { 1, 2 };
        int[] arr2 = { 2, 3, 4 };

        int[] result = MergeSort.merge(arr1, arr2);

        assertArrayEquals(new int[] { 1, 2, 2, 3, 4 }, result);
    }

    @Test
    void merge_Arr1IsLongerThanArr2_ReturnMergedArray() {
        int[] arr1 = { 1, 2, 2 };
        int[] arr2 = { 3, 4 };

        int[] result = MergeSort.merge(arr1, arr2);

        assertArrayEquals(new int[] { 1, 2, 2, 3, 4 }, result);
    }
}
