import java.util.*;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        
        // Precompute lengths of strictly increasing subarrays starting at each position
        int[] lengths = new int[n];
        
        for (int i = 0; i < n; i++) {
            lengths[i] = 1;
            int j = i;
            while (j + 1 < n && nums.get(j + 1) > nums.get(j)) {
                j++;
            }
            int len = j - i + 1;
            // Fill all positions in this segment
            for (int k = i; k <= j; k++) {
                lengths[k] = len - (k - i);
            }
            i = j; // Skip to end of this segment
        }
        
        int max2 = 0;
        
        // Check all positions
        for (int i = 0; i < n; i++) {
            int k = lengths[i]; // first segment length
            
            if (i + k < n) {
                int p = lengths[i + k]; // next segment length
                max2 = Math.max(max2, Math.min(k, p));
            }
            
            // Split current segment in half
            max2 = Math.max(max2, k / 2);
        }
        
        return max2;
    }
}
