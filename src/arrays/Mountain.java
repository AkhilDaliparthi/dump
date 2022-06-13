package arrays;

public class Mountain {

    public int getPeakRange(int[] A) {
        int max = 0;
        if(A.length<3) {
            return 0;
        }
        for(int i=1; i<A.length-1; i++) {
            if(A[i]>A[i-1] && A[i]>A[i+1]) {
                int k=i-1;
                while(k>0 && A[k]>A[k-1]) {
                    k--;
                }
                while(i<A.length-1 && A[i]>A[i+1]) {
                    i++;
                }
                if(max < (i-k)) {
                    max = (i-k)+1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Mountain mountain = new Mountain();
        int[] input = {5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};
        System.out.println(mountain.getPeakRange(input));
    }
}
