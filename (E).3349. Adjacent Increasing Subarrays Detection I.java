class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int t = 0;
        for (int u = 0; u + 2 * k <= nums.size(); u++) {   // ensure within bounds
            if (temp(u, k, nums) && temp(u + k, k, nums))  // FIX: use u + k instead of u + k - 1
                return true;
        }
        return false;
    }

    boolean temp(int u, int k, List<Integer> nums) {
        int count = 0;
        if (u + k > nums.size()) return false;

        for (int j = u + 1; j < u + k; j++) {
            if (nums.get(j) > nums.get(j - 1)) {
                count++;
            }
        }

        if (count == k - 1) return true;
        else return false;
    }}
