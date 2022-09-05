package arrays;

public class NextPermutation {

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void reverse(int[] a, int i, int j){
        while(i < j){
            swap(a,i++,j--);
        }
    }
    public int[] solution(int[] a) {
        int n = a.length;
        int j = n-1;
        while(j > 0 && a[j] < a[j-1]){
            j--;
        }
        if(j > 0){
            int index = -1;
            for(int i = j; i < n; i++){
                if(a[i] > a[j-1]){
                    index = i;
                }
            }
            swap(a,j-1,index);
        }
        reverse(a,j,n-1);
        return a;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation =  new NextPermutation();
        int[] res = nextPermutation.solution(new int[]{1,2,3,6,5,4});
        for(int i : res) {
            System.out.println(i+"\t");
        }
    }
}
