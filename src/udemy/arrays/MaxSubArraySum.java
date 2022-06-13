package udemy.arrays;

public class MaxSubArraySum {

    public int solution (int[] input) {
        int max = 0;
        int temp = 0;
        for(int i=0; i<input.length; i++) {
            temp = temp+input[i];
            if(max<temp) {
                max=temp;
            }
            if(temp<0) {
                temp=0;
            }
        }
        return max;
    }

    public static void main(String[] args){
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int[] input = {-1,2,3,4,-2,6,-8,3};
        System.out.println(maxSubArraySum.solution(input));
    }
}
