package org.rainbow.algorithms.sorting;

import org.apache.commons.lang3.ObjectUtils;

public final class MergeSort {

    private MergeSort() {
    }

    public static int[] sort(int[] arr) {
        return ObjectUtils.isNotEmpty(arr) ? sort(arr, 0, arr.length - 1) : arr;
    }

    // Made package-private for unit testing
    static int[] sort(int[] arr, int start, int end) {
        if (ObjectUtils.isEmpty(arr)) {
            return arr;
        }
        int length = end - start + 1;
        if (length == 1) {
            return new int[] { arr[start] };
        }
        int split = length / 2;
        int[] left = sort(arr, start, start + split - 1);
        int[] right = sort(arr, start + split, end);
        return merge(left, right);
    }

    // Made package-private for unit testing
    static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            result[k++] = arr1[i];
            i++;
        }
        while (j < arr2.length) {
            result[k++] = arr2[j];
            j++;
        }
        return result;
    }

}
