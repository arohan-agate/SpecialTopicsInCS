// First Bad Version: O(log(n))
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int mid = 1/2 + n/2;
        int left = 1;
        int right = n;
        List<Integer> badVals = new ArrayList<>();
        while (left <= right) {
            mid = left + (right-left)/2;
            if (isBadVersion(mid)) {
                badVals.add(mid);
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return badVals.get(badVals.size()-1);
    }
}




// Find First and Last Position of Element in Sorted Array: O(log(n))
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean isTarget = true;
        int numTargets = 0;
        int indexLowestTarget = nums.length;
        while (isTarget) {
            while (left <= right) {
                int mid = left + (right-left)/2;
                if (nums[mid] == target) {
                    numTargets++;
                    if (mid < indexLowestTarget) {
                        indexLowestTarget = mid;
                    }
                    nums[mid] = target + 1;
                }
                else if (target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            isTarget = false;
        }
        if (numTargets == 0) {
            return new int[] {-1, -1};
        }
        
        else {
            return new int[] {indexLowestTarget, indexLowestTarget+numTargets-1};
        }
    }
}



// Search a 2-D Matrix: O(log(n))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row : matrix){
            if(target <= row[row.length-1]) {
                int left = 0; 
                int right = row.length-1;
                
                while(left < right){
                    int mid = left + (right - left)/2;
                    
                    if(row[mid] < target) {
                        left++;
                    }
                    else if(row[mid] > target) {
                        right = mid;
                    }
                    else {
                        return true;
                    }
                }
                if(left == right){
                    if(row[left] == target)
                        return true;
                }
                break;
            }
        }
        return false;
    }
}


// Search a 2-D Matrix II
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        boolean notFound = true;
        while (notFound) {
            if (target < matrix[row][col]) {
                row--;
            }
            else if (target > matrix[row][col]) {
                col++;
            }
            else {
                return true;
            }
            if (row < 0 || col >= matrix[0].length) {
                return false;
            }
        }
        return false;
    }
}
