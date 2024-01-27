package java;

/* Array
 * Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, 
 * Ashe gets poisoned for a exactly duration seconds. More formally, an attack at second t will
 * mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. If Teemo 
 * attacks again before the poison effect ends, the timer for it is reset, and the poison effect 
 * will end duration seconds after the new attack.
 * 
 * You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that 
 * Teemo attacks Ashe at second timeSeries[i], and an integer duration.
 * 
 * Return the total number of seconds that Ashe is poisoned.
 * 
 * Constraints:
 *  1 <= timeSeries.length <= 104
 *  0 <= timeSeries[i], duration <= 107
 *  timeSeries is sorted in non-decreasing order.
 * 
 * Test:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: timeSeries.length = 1, timeSeries.length = 104
 * 4. edge cases: timeSeries[i] = 0, timeSeries[i] = 107
 * 5. edge cases: duration = 0, duration = 107
 * 6. very small/ huge difference between timeSeries[i]
 * 
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

/* My solution. Compare the time difference with duration and add the right amount of time.
 */
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // Add the last duration first.
        int poisonedDuration = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int timeDiff = timeSeries[i] - timeSeries[i - 1];
            if (timeDiff < duration) {
                poisonedDuration += timeDiff;
            } else {
                poisonedDuration += duration;
            }

        }
        return poisonedDuration;
    }
}

/* Start and end point solution.
 * https://leetcode.com/problems/teemo-attacking/solutions/97465/o-n-java-solution-using-same-idea-of-merge-intervals/
 * Use two variable to record current start and end point.
 * If the start of new interval is greater than current end, meaning NO overlapping, we can sum 
 * the current interval length to result and then update start and end.
 * Otherwise just update the current end;
 */
class Solution2 {
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                result += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        result += end - start;
        
        return result;
    }
}

/* Same idea as my solution but use minimum.
 * https://leetcode.com/problems/teemo-attacking/solutions/97584/easy-to-understand-java-solution/
 */
class Solution3 {
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        
        if(timeSeries.length == 0)return 0;
        if(timeSeries.length == 1)return duration;
        
        int total = 0;
        for(int i=1; i<timeSeries.length;i++)
        {
            total += Math.min(duration,timeSeries[i]-timeSeries[i-1]);
        }
        
        total += duration;
     
     return total;   
    }
}