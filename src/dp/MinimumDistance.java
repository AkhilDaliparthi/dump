package dp;

public class MinimumDistance {

    public int minDistanceRec(String word1, String word2) {
        int m = word1.length() , n = word2.length() ;
        return helper(word1 , word2 , m-1 , n-1 );
    }

    private int helper(String word1, String word2 , int i , int j){
        if(j<0 && i>=0){ // We have to delete the rest of the characters from word1 since after this i we have the word2 in word1
            return i+1;
        }
        if(i<0 && j>=0) return j+1; // We have to insert the rest of the characters in word1
        if(i<0 && j < 0) return 0; // Both are emptied.

        // end of base cases
        if(word1.charAt(i) == word2.charAt(j)){
            return helper(word1 , word2 , i-1 , j-1 );
        }else{
            // We have 3 possibilities, insert, delete , replace. Try all and return minimum
            int insert = 1 + helper(word1 , word2 , i , j-1 ); // Hypothatical insert. Since, we have matched one char after insert but word1.charAt(i) still needto be checked for further calls
            int delete = 1 + helper(word1 , word2 , i-1 , j ); // We have deleted word1.charAt(i) . So, need to reduce i but j remains there as we have not matched it yet
            int replace = 1 + helper(word1 , word2 , i-1 , j-1 ); // We have matched char by replacing the char. So reduce both.

            return Math.min ( insert , Math.min (delete , replace) );
        }
    }

    // DP MEMOIZATION
    public int minDistanceTopDown(String word1, String word2) {
        int m = word1.length() , n = word2.length() ;
        int [][] dp = new int[m+1][n+1];
        for( int k=0 ; k<=m ; k++){
            for( int l=0 ; l<=n ; l++){
                dp[k][l] = -1;
            }
        }

        return helper(word1 , word2 , m-1 , n-1 , dp);
    }

    private int helper(String word1, String word2 , int i , int j , int [][] dp){
        if(j<0 && i>=0){ // We have to delete the rest of the characters from word1 since after this i we have the word2 in word1
            return i+1; // Since we have to delete i+1 characters from word1;
        }
        if(i<0 && j>=0) return j+1; // Since we have to insert j+1 characters in word1;
        if(i<0 && j < 0) return 0; // Both are emptied.

        // end of base cases
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = helper(word1 , word2 , i-1 , j-1 , dp);
        }else{
            // We have 3 possibilities, insert, delete , replace. Try all and return minimum
            int insert = 1 + helper(word1 , word2 , i , j-1 , dp); // Hypothatical insert. Since, we have matched one char after insert but word1.charAt(i) still needto be checked for further calls
            int delete = 1 + helper(word1 , word2 , i-1 , j , dp); // We have deleted word1.charAt(i) . So, need to reduce i but j remains there as we have not matched it yet
            int replace = 1 + helper(word1 , word2 , i-1 , j-1 , dp); // We have matched char by replacing the char. So reduce both.

            dp[i][j] = Math.min ( insert , Math.min (delete , replace) );
        }
        return dp[i][j];
    }

    // TABULATION
    public int minDistance(String word1, String word2) {
        int m = word1.length() , n = word2.length() ;
        int [][] dp = new int[m+1][n+1];
        // BASE CASES serial wise from memoization for easy undderstanding

        for(int i=1 ; i<=m ; i++){ // Since we have to delete i characters from word1;
            dp[i][0] = i;
        }
        for(int j=1 ; j<=n ; j++){ // Since we have to insert j characters in word1;
            dp[0][j] = j;
        }
        dp[0][0] = 0; // Both are emptied.

        // end of base cases
        for(int i=1 ; i<=m ; i++){
            for(int j=1 ; j<=n ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] ;
                }else{
                    // We have 3 possibilities, insert, delete , replace. Try all and return minimum
                    int insert = 1 + dp[i][j-1]; // Hypothatical insert. Since, we have matched one char after insert but word1.charAt(i) still needto be checked for further calls
                    int delete = 1 + dp[i-1][j]; // We have deleted word1.charAt(i) . So, need to reduce i but j remains there as we have not matched it yet
                    int replace = 1 + dp[i-1][j-1]; // We have matched char by replacing the char. So reduce both.

                    dp[i][j] = Math.min ( insert , Math.min (delete , replace) );
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        MinimumDistance minimumDistance = new MinimumDistance();
        System.out.println(minimumDistance.minDistance("horse", "ros"));
    }
}
