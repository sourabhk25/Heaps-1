// Time Complexity : O(n log k) where n = no of elements in array
// Space Complexity : O(k) stoting k elements in min-heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use a min-heap of size k.
//   - Insert elements into the heap; if heap size exceeds k, remove the smallest element.
//   - After processing all elements, the root of the heap is the kth largest element.

import java.util.PriorityQueue;

public class kthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);  //default are min heaps in Java
        for(int num: nums) { // o(n)
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();  //log k
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        kthLargestInArray solution = new kthLargestInArray();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
