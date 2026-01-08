package java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

Constraints:
- 1 <= s.length <= 104
- s consists of parentheses only '()[]{}'.

 Test:
1. s.length = 1, s.length = 10^4
2. Close by wrong bracket type, {]
3. Wrong order, [{]}
4. Start with close bracket.

 Time complexity: O(n)
 Space complexity: O(n)
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}