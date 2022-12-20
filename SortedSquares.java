import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
    }

    public static int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];

        int left = 0;
        int right = size -1;

        for (int i = size - 1; i >= 0; i--) {
            int item;
            if (Math.abs(nums[right]) >= Math.abs(nums[left])) {
                item = nums[right];
                right--;
            }
            else {
                item = nums[left];
                left++;
            }
            res[i] = item * item;
        }

        return res;
    }
}
