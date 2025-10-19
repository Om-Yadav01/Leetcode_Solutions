class Solution {
    public String smallestString(String s) {
        if (s.isEmpty()) return ""; // Handle empty string
        
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        // Check if all characters are 'a'
        boolean allAs = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'a') {
                allAs = false;
                break;
            }
        }
        
        // If all 'a's, replace last character with 'z'
        if (allAs) {
            sb.setCharAt(n - 1, 'z');
            return sb.toString();
        }
        
        // Find first non-'a' substring and replace with predecessors
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            i++;
        }
        while (i < n && s.charAt(i) != 'a') {
            sb.setCharAt(i, (char)(s.charAt(i) - 1));
            i++;
        }
        
        return sb.toString();
    }
}
