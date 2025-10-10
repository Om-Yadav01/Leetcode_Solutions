class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] prefix = new int[n + 1]; // prefix count of plates (*)
        int[] leftCandle = new int[n]; // nearest candle to the left
        int[] rightCandle = new int[n]; // nearest candle to the right
        int[] ans = new int[queries.length];

        // Step 1: prefix sum of plates
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (c[i] == '*' ? 1 : 0);
        }

        // Step 2: nearest left candle
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (c[i] == '|') last = i;
            leftCandle[i] = last;
        }

        // Step 3: nearest right candle
        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (c[i] == '|') last = i;
            rightCandle[i] = last;
        }

        // Step 4: answer queries
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int L = rightCandle[start]; // first candle >= start
            int R = leftCandle[end];    // last candle <= end

            if (L != -1 && R != -1 && L < R) {
                ans[i] = prefix[R] - prefix[L];
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }
}
