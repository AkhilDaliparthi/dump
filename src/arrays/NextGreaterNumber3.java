package arrays;

public class NextGreaterNumber3 {

    public int solution(int m) {
        long n = m;
        if(n<10) {
            return -1;
        }
        int[] count = new int[10];
        int prevRem=-1;
        int currRem=-1;
        while(n>0) {
            currRem = (int)n%10;
            n=n/10;
            count[currRem]++;
            if(currRem<prevRem) {
                int num = currRem+1;
                while(num<10 && count[num]==0) {
                    num++;
                }
                count[num]--;
                n=n*10+num;
                for(int i=0; i<10; i++) {
                    while(count[i]>0) {
                        n=n*10+i;
                        count[i]--;
                    }
                }
                return n>Integer.MAX_VALUE ? -1 : (int)n;
            }
            prevRem = currRem;
        }
        return -1;
    }

    public static void main(String[] args) {
        NextGreaterNumber3 nextGreaterNumber3 = new NextGreaterNumber3();
        System.out.println(nextGreaterNumber3.solution(23));
    }
}
