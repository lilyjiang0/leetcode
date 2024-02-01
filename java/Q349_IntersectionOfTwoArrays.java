package java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Hash Table, Two Pointers, Binary Search, Sort
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element 
 * in the result must be unique and you may return the result in any order.
 * 
 * Constraints:
 *  1 <= nums1.length, nums2.length <= 1000
 *  0 <= nums1[i], nums2[i] <= 1000
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: nums1.length, nums2.length = 1, nums1.length, nums2.length = 1000
 * 4. edge cases: nums1[i], nums2[i] = 0, nums1[i], nums2[i] = 1000
 * 5. very long nums1, short nums2
 * 6. all elements are the same
 * 7. no intersection
 */

/* Set solution.
 * Time complexity: O(n)
 * Space complexity: O(num of intersections)
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create set for nums1.
        Set<Integer> nums1Set = new HashSet<>();
        for (int num1 : nums1) {
            nums1Set.add(num1);
        }
        // Loop through nums2 to find intersection using set of nums1.
        Set<Integer> intersection = new HashSet<>();
        for (int num2 : nums2) {
            if (nums1Set.contains(num2)) {
                intersection.add(num2);
            }
        }
        // Convert set to array to return.
        int[] res = new int[intersection.size()];
        int i = 0;
        for (int inter : intersection) {
            res[i++] = inter;
        }
        return res;
    }
}

/* Two pointers solution
 * Time complexity: O(nlog(n))
 * Space complexity: O(num of intersections)
 */
class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        Set<Integer> intersection = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        // Convert set to array to return.
        int[] res = new int[intersection.size()];
        int k = 0;
        for (int inter : intersection) {
            res[k++] = inter;
        }
        return res;
    }
}