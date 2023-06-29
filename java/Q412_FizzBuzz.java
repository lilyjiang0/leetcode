package java;

import java.util.ArrayList;
import java.util.List;

/* Math, String, Simulation
 * Given an integer n, return a string array answer (1-indexed) where:
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5. 
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * Assumption: 1 <= n <= 10^4.
 */


/* % approach.
  * Time complexity: O(n)
  * Space complexity: O(1)
  *
  * Test:
  * 1. Normal cases, 3,9,30
  * 2. edge cases, 1 & 10^4
  */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}


/* No % approach. Faster.
  * Time complexity: O(n)
  * Space complexity: O(1)
  *
  * Test:
  * 1. Normal cases, 3,9,30
  * 2. edge cases, 1 & 10^4
  */
class Solution2 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        // Base case.
        int fizz = 3;
        int buzz = 5;
        for (int i = 1; i <= n; i++) {
            if (i == fizz && i == buzz) {
                result.add("FizzBuzz");
                // Next integer that can be divisible by 3&5;
                fizz += 3;
                buzz += 5;
            } else if (i == fizz) {
                result.add("Fizz");
                // Next integer that can be divisible by 3;
                fizz += 3; 
            } else if (i == buzz) {
                result.add("Buzz");
                // Next integer that can be divisible by 5;
                buzz += 5;
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}