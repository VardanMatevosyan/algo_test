package binery_search;

public class TargetInRotatedSortedArray {

    public static void main(String[] args) {
//        int foundIndex = search(new int[]{5, 1, 3}, 5);
        int foundIndex = search(new int[]{1, 3}, 3);
//        int foundIndex = search(new int[]{4,5,6,7,0,1,2}, 3);
        System.out.println("Index is " + foundIndex);
    }

    public static int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (r + l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }
        return -1;
    }
}