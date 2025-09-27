package binery_search;

public class BinarySearchIterative {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l <= r) {
            mid = (l + r) / 2;
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
