class Solution {
    public int cyclicDistance(char ch1, char ch2) {
        int dist = Math.abs(ch1 - ch2);
        return Math.min(dist, 26 - dist);
    }
    public String getSmallestString(String s, int k) {
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++) {
            int distToA = cyclicDistance(sArray[i], 'a');
            if(distToA <= k) {
                sArray[i] = 'a';
                k -= distToA;
            } else if(k > 0) {
                sArray[i] = (char) (sArray[i] -  k);
                k = 0;
            }
        }
        return new String(sArray);
    }
}
