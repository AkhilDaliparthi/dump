package companies.amazon;

public class GasInCar {

    public int solution(int[] A, int[] B) {
        int total = 0;
        for(int i=0; i<A.length; i++) {
            total += A[i] - B[i];
        }
        if(total<0) {
            return -1;
        }
        int start = 0;
        int gasInCar = 0;
        for(int i=0; i<A.length; i++) {
            int curr = A[i] - B[i];
            if(gasInCar+curr<0) {
                start=i+1;
                gasInCar = 0;
            } else {
                gasInCar += curr;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        GasInCar gasInCar = new GasInCar();
        System.out.println(gasInCar.solution(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
