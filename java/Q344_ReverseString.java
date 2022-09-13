package java;
/* Two Pointers & String
 * Write a function that reverses a string. The input string is given as an array of 
 * characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */

import java.util.Stack;

/* Two pointers
  * Time complexity: O(n)
  * Space complexity: O(1)
  *
  * Test:
  * 1. Normal
  * 2. wrong input type
  * 3. long array
  * 4. single element array
  */
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}


/* Recursion
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution2 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        solve(s, i, j);
    }

    public void solve(char[] s, int i, int j) {
        if (i >= j) {
            return;
        }
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        i++;
        j--;
        solve(s, i, j);
    }
}

/* Stack
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution3 {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            // push elements into stack
            stack.push(s[i]);
        }
        int j = 0;
        while (stack.size() > 0) {
            // pop elements to array
            s[j] = stack.pop();
            j++;
        }
    }
}