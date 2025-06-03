import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store (number -> index) pairs
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            // Check if the complement exists in the HashMap
            if (numMap.containsKey(complement)) {
                // If it exists, we found the pair.
                // Return the index of the complement and the current index.
                return new int[] { numMap.get(complement), i };
            }

            // If the complement doesn't exist, add the current number and its index to the HashMap
            numMap.put(currentNum, i);
        }

        // If no solution is found (though the problem states there's exactly one solution),
        // you might throw an exception or return an empty array, depending on requirements.
        // For this problem, it's guaranteed to find a solution.
        return new int[] {}; // Should not be reached based on problem constraints
    }
}