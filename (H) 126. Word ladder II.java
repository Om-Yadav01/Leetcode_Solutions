import java.util.*;

class Solution {
    public List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> start = new ArrayList<>();
        start.add(startWord);
        q.add(start);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        List<List<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
            q.remove();

            // erase all words used in previous levels
            if (vec.size() > level) {
                level++;
                for (String word : usedOnLevel) {
                    st.remove(word);
                }
                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            // first sequence where we reached the end
            if (word.equals(targetWord)) {
                if (ans.size() == 0) ans.add(new ArrayList<>(vec));
                else if (ans.get(0).size() == vec.size()) ans.add(new ArrayList<>(vec));
            }

            // try all possible 1-letter transformations
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }

        return ans;
    }
}
