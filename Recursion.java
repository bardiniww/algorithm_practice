import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 13, 99};
        System.out.println(sumArray(arr, 0));
        System.out.println(elementsCount(arr, 0));
        System.out.println(maxValue(arr, arr[0], 0));
        System.out.println(binarySearch(arr, 2, 0, arr.length - 1));
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 4, 3, 2, 1, 0}, arr.length)));
    }

    private static int sumArray(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }

        return array[index] + sumArray(array, ++index);
    }

    private static int elementsCount(int[] array, int count) {
        if (count == array.length) {
            return count;
        }

        return elementsCount(array, ++count);
    }

    private static int maxValue(int[] arr, int max, int ind) {
        if (ind == arr.length) {
            return max;
        }

        return maxValue(arr, arr[ind] > max ? arr[ind] : max, ++ind);
    }

    private static int binarySearch(int[] arr, int item, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (item == arr[mid]) {
            return mid;
        }

        if (lo == hi) {
            return -1;
        }

        return binarySearch(
                arr,
                item,
                item > arr[mid] ? ++mid : lo,
                item <  arr[mid] ? --mid : hi
        );
    }

    private static int[] bubbleSort(int[] arr, int i) {
        if (i == 0) {
            return arr;
        }

        for (int j = 0; j < i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }

        return bubbleSort(arr, --i);
    }

    private static void swap(int[] arr, int left, int right) {
        arr[left] = arr[left] + arr[right];
        arr[right] = arr[left] - arr[right];
        arr[left] = arr[left] - arr[right];
    }
}
