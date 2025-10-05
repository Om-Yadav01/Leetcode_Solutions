class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        String[] part = s.split(" ");
        int n = part.length;
        //System.out.print(n);
        res = part[part.length-1].length();
        return res;
    }
}
