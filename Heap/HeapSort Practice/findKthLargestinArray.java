class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        heapify the first k elements so that it's a min heap of size k. O(k) 
        for the rest (n - k) elements at position i: O(n - k) * log k
        Case 1: nums[i] > nums[0], swap(0, i), and percolate down 
        Case 2: else: ignore
        Time : O(k) +  (n - k) * log k  
        */
        if (nums == null || k > nums.length) {
            return -1;
        }
        
        heapify(nums, 0, k - 1); //size is the ranges/area of the heapify, not the length of nums
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                percolateDown(nums, 0, k);
            }
        }
        return nums[0];
    }
    
    private void heapify(int[] nums, int left, int right) {
        // get the heap size
        int size = right - left + 1;
        // !!start from the last element with child size/2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(nums, i, size);
        } 
    }
    
    private void percolateDown(int[] nums, int index, int size) {
        // keep swapping until no more swapping is needed
        while (index <= (size / 2 - 1)) { // as long as there's child
            int lChild = 2 * index + 1;
            int rChild = 2 * index + 2;
            int candidate = lChild;
            if (rChild < size) { // range is the size, not nums.length
                if (nums[rChild] <= nums[lChild]) {
                    candidate = rChild;
                }
            }
            if (nums[index] > nums[candidate]) {
                swap(nums, index, candidate);
            } else {
                break;
            }
            index = candidate;
        }
       
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
