class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;  

        while (numBottles >= numExchange) {
           
            numBottles = (numBottles - numExchange + 1);
            numExchange += 1;
            ans += 1;
        }

        return ans;
    }
}
