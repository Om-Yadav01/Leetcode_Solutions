class Solution {
    public int minimumCost(int[] nums) {
        int m = Integer.MAX_VALUE;
        int l=0;
l=nums[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               
                   int  s = nums[i] + nums[j] ;
                    m = Math.min(m, s);
                
            }
        }
        return m+l;
    }
}
