package companies.amazon;

public class CandyDistribution {

    public int solution(int[] A) {
        int[] candies = new int[A.length];
        int res = 0;
        candies[0] = 1;
        for(int i=1; i<A.length; i++) {
            candies[i] = 1;
            if(A[i]>A[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }
        for(int i=candies.length-1; i>0; i--) {
            if(A[i-1]>A[i] && candies[i-1]<=candies[i]) {
                candies[i-1] = candies[i]+1;
            }
        }
        for(int i=0; i<candies.length; i++) {
            res+=candies[i];
        }
        return res;
    }

    public static void main(String[] args) {
        CandyDistribution candyDistribution = new CandyDistribution();
        System.out.println(candyDistribution.solution(new int[]{1, 5, 2, 1}));
    }
}
