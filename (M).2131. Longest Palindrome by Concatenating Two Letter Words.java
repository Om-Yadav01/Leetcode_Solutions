class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) freq.put(w, freq.getOrDefault(w, 0) + 1);

        int length = 0;
        boolean hasCenter = false;

        // iterate over a copy of the keys to avoid concurrent-modification problems
        for (String w : new ArrayList<>(freq.keySet())) {
            int cnt = freq.getOrDefault(w, 0);
            if (cnt == 0) continue;

            char a = w.charAt(0);
            char b = w.charAt(1);

            if (a != b) {
                String rev = "" + b + a;
                int cntRev = freq.getOrDefault(rev, 0);
                if (cntRev > 0) {
                    int pairs = Math.min(cnt, cntRev);
                    length += 4 * pairs; // each pair contributes 4 chars
                    freq.put(w, cnt - pairs);
                    freq.put(rev, cntRev - pairs);
                }
            } else { // symmetric like "aa"
                // use floor(cnt/2) pairs
                length += (cnt / 2) * 4;
                // if there is an odd leftover (one "aa"), it can be candidate for center
                if (cnt % 2 == 1) hasCenter = true;
                // mark used up (optional, not strictly necessary here)
                freq.put(w, 0);
            }
        }

        if (hasCenter) length += 2; // at most one center
        return length;
    }
}
