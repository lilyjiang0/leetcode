package java;

/* string
You own a Goal Parser that can interpret a string command. 
The command consists of an alphabet of "G", "()" and/or "(al)" in some order. 
The Goal Parser will interpret "G" as the string "G", "()" as the string "o", 
and "(al)" as the string "al". The interpreted strings are then concatenated 
in the original order.
Given the string command, return the Goal Parser's interpretation of command.

Constraints:
- 1 <= command.length <= 100
- command consists of "G", "()", and/or "(al)" in some order.

Time Complexity: O(n)
Space Complexity: O(n)

Tests:
- Single token e.g. "G", "()"
- Mixed token e.g. "G()", "()(al)(G)"
- Repetition e.g. "()()()"
- command length = 100
 */
class Solution {
    public String interpret(String command) {
        // Allocate command-length memory because length of output 
        // must be smaller than length of command.
        StringBuilder result = new StringBuilder(command.length());
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                result.append('G');
            } else if (command.charAt(i) == '(') {
                // Two cases if a left bracket is found.
                if (command.charAt(i + 1) == ')') {
                    result.append('o');
                    i++; // Skip the right bracket.
                } else {
                    result.append('a').append('l');
                    i += 3; // Skip 'al)'.
                }
            }
        }
        return result.toString();
    }
}