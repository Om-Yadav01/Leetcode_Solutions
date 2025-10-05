class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m=grid.size();
        int n=grid.get(0).size();

        int[][] dp=new int[m][n];
        int maxScore=Integer.MIN_VALUE;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int maxVal=Integer.MIN_VALUE;

                if(i+1<m){
                    maxVal=Math.max(maxVal,dp[i+1][j]);
                }

                if(j+1<n){
                    maxVal=Math.max(maxVal,dp[i][j+1]);

                }

                //if valid move
                if(maxVal!=Integer.MIN_VALUE){
                    maxScore=Math.max(maxScore,maxVal-grid.get(i).get(j));
                }

                //update dp table
                dp[i][j]=Math.max(
                    grid.get(i).get(j),Math.max(
                        i+1<m?dp[i+1][j]:Integer.MIN_VALUE,
                        j+1<n?dp[i][j+1]:Integer.MIN_VALUE
                    )
                );
            }
        }

        return maxScore;
        
    }
}
