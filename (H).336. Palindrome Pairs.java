import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // Step 1: Store each word and its index
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // Step 2: For each word, check all possible splits
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();

            for (int cut = 0; cut <= len; cut++) {
                String prefix = word.substring(0, cut);
                String suffix = word.substring(cut);

                // Case 1: prefix is palindrome → need reversed suffix before
                if (isPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(reversedSuffix) && map.get(reversedSuffix) != i) {
                        res.add(Arrays.asList(map.get(reversedSuffix), i));
                    }
                }

                // Case 2: suffix is palindrome → need reversed prefix after
                // (avoid duplicate checking when suffix is empty)
                if (cut != len && isPalindrome(suffix)) {
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (map.containsKey(reversedPrefix) && map.get(reversedPrefix) != i) {
                        res.add(Arrays.asList(i, map.get(reversedPrefix)));
                    }
                }
            }
        }

        return res;
    }

    // helper function to check palindrome
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
            }
        return true;
    }
}
