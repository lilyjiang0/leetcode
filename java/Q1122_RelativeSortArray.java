package java;

import java.util.TreeMap;

/* Hash Table, Binary Search.
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in 
 * arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same 
 * as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in 
 * ascending order.
 * 
 * Constraints:
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * All the elements of arr2 are distinct.
 * Each arr2[i] is in arr1.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: arr1.length/arr2.length = 1, arr1.length/arr2.length = 1000
 * 4. edge cases: arr1[i], arr2[i] = 0, arr1[i], arr2[i] = 1000
 * 5. arr1 with/ without elements that do not appear in arr2.
 * 6. repeat element in arr1
 */

/* Array solution. Use an array to count every element, go through the arr2 to update arr1 and 
 * and last update the elements that do not appear in arr2.
 * https://leetcode.com/problems/relative-sort-array/solutions/335056/java-in-place-solution-using-counting-sort/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001]; // Constraint length <= 1000.
        // Count elements in arr1.
        for (int num : arr1) {
            count[num]++;
        }
        int i = 0;
        // Use arr2's order to update arr1.
        for (int num : arr2) {
            while (count[num]-- > 0) {
                arr1[i++] = num;
            }
        }
        // Update the remaining one that does not appear in arr2.
        for (int j = 0; j < count.length; j++) {
            while (count[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}

/* Treemap solution. Longer runtime and more memory usage, but can work without 
 * the length constraint.
 * Difference https://stackoverflow.com/questions/2444359/what-is-the-difference-between-a-hashmap-and-a-treemap
 * https://leetcode.com/problems/relative-sort-array/solutions/335056/java-in-place-solution-using-counting-sort/
 * Time complexity: O(nlog(n))
 * Space complexity: O(n)
 */
class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Use tree map because the order of key can be sorted.
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        // Store arr1 into a tree map.
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        // Use arr2's order to update arr1.
        for (int num : arr2) {
            for (int j = 0; j < map.get(num); j++) {
                arr1[i++] = num;
            }
            map.remove(num);
        }
        // Update arr1 with remaining number in the map.
        for (int num : map.keySet()) {
            for (int j = 0; j < map.get(num); j++) {
                arr1[i++] = num;
            }
        }
        return arr1;
    }
}