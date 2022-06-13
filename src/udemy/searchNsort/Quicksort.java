package udemy.searchNsort;

public class Quicksort {

    public void sort(int[] arr, int low, int high) {
        if(low<high) {
            int p = partition(arr, low, high);
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    public int partition(int[] arr, int start, int p) {
        int index = start;
        int pivot = arr[p];
        for(int i=start; i<p; i++) {
            if(arr[i]<pivot) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index, p);
        return index;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        Quicksort quicksort = new Quicksort();
        quicksort.sort(arr, 0, arr.length-1);
        for(int i:arr) {
            System.out.println(i);
        }
    }
}
