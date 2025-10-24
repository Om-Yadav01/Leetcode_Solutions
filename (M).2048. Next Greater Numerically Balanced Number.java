class Solution {
    public int nextBeautifulNumber(int num) {
        num++; // start from next number
        
        while (true) {
            if (isBalanced(num)) return num; // if found, return it
            num++;
        }
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];  // frequency array
        int x = num;

        while (x > 0) {
            int digit = x % 10;
            count[digit]++;
            x /= 10;
        }

        // Check each digit
        for (int d = 0; d <= 9; d++) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }
}
