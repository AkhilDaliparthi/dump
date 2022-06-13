package dp;

public class JumpingFrog {

    public int recSolution(int[] steps, int currStep) {
        if(currStep>=steps.length) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=steps[currStep]; i++) {
            if(currStep+i<steps.length) {
                int temp = recSolution(steps, currStep+steps[currStep+i]);
                if(temp+1<min && temp!=Integer.MAX_VALUE) {
                    min = temp+1;
                }
            }
        }
        return min;
    }

    public int solution(int[] steps) {
        int count = 0;
        int i = 0;
        while(i<steps.length) {
            count++;
            int max_index = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=1; j<=steps[i] && i+j < steps.length; j++) {
                if(i+steps[j]>=steps.length) {
                    return count;
                }
                if(max<i+steps[j]) {
                    max = i+steps[j];
                    max_index = i+j;
                }
            }
            i = max_index;
        }
        return count;
    }

    public static void main (String[] args){
        JumpingFrog jumpingFrog = new JumpingFrog();
        int[] steps = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(jumpingFrog.solution(steps));
    }
}
