class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        System.out.print(n);
        if(n<=8) return n;
        else{
            if(n<=16) {
                return 8+(n-8)*2;
            }
            else if(n<=24){
                return 24+(n-16)*3;
            }
           
       }
        return 48+(n-24)*4;
    }
}
