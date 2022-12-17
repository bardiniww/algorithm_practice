/**
 * O(Log n)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 9, 10, 27, 30, 100, 101, 110, 203, 400};
        int existItem = 1;
        int notExistItem = 401;
        System.out.println("with exist item index = " + search(array, existItem));
        System.out.println("with not exist item index = " + search(array, notExistItem));
    }

    /**
     * Binary search
     *
     * @param array sort is must
     * @param searchItem item to search
     * @return index of searched item or Null if not found
     */
    public static Integer search(int[] array, int searchItem) {
        //optional part of array sort validation
        boolean isArraySorted = isArraySorted(array);
        if (!isArraySorted) {
            throw new RuntimeException("Only sorted array accepted");
        }

        //main part
        int lowIndex = 0;
        int highIndex = array.length - 1;
        int midIndex;
        int steps = 0;
        while (lowIndex <= highIndex) {
            steps++;
            midIndex = (lowIndex + highIndex) / 2;
            if (searchItem == array[midIndex]) {
                System.out.printf("found by %d steps%n", steps);
                return midIndex;
            } else if (searchItem > array[midIndex]) {
                lowIndex = midIndex + 1;
            } else {
                highIndex = midIndex - 1;
            }
        }

        System.out.printf("not found by %d steps%n", steps);
        return null;
    }

    private static boolean isArraySorted(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
