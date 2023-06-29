package java;

/* String
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 * 
 * Constraints:
 *  The given address is a valid IPv4 address.
 *  
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: 0.0.0.0, 255.255.255.255
 */

/* Loop through string, check and replace each character.
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 */
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            // Check for ".".
            if (c == '.') {
                // Replace with "[.]".
                sb.append("[.]");
            } else {
                // Keep original.
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

/* Use built-in replace function for string.
 */
class Solution2 {
    public String defangIPaddr(String address) {
        address = address.replace(".", "[.]");
        return address;
    }
}