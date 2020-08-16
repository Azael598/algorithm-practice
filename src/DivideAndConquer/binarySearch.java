package DivideAndConquer;

public class binarySearch {
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        //when left = right,the location is found but if the target doesn't exist u need another iteration
        //for example,1 1 2 target 2,when l=r at 2, the next iteration will prove 2 is the answer
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * if u're given a array containing mutiple targets,
     * the bounds of target will be unable to locate
     * @return the first key that >= target
     */
    int binarySearchLeftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int mid;
        //when left = right,location of left bound is found even if it doesn't exist
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    /**
     * @return the first key that > target
     * */
    int binarySearchRightBound(int[] nums, int target){
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int mid;
        //when left = right,location of left bound is found even if it doesn't exist
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

}
