package udemy.searchNsort;

public class MergeSort {

    public void sort(int[] arr, int low, int high) {
        if(low<high) {
            int middle = low + (high-low)/2;
            sort(arr, low, middle);
            sort(arr, middle+1, high);
            merge(arr, low, middle, high);
        }
    }

    public void merge(int[] arr, int low, int middle, int high) {
        int s1=middle-low+1;
        int s2=high-middle;
        int[] left = new int[s1];
        int[] right = new int[s2];

        for(int i=0; i<s1; i++) {
            left[i] = arr[low+i];
        }

        for(int i=0; i<s2; i++) {
            right[i] = arr[middle+1+i];
        }

        int i=0;
        int j=0;
        int k=low;
        while(i<s1 && j<s2) {
            if(left[i]<right[j]) {
                arr[k]=left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<s1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<s2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort.sort(arr, 0, arr.length-1);
        for(int i: arr) {
            System.out.println(i);
        }
    }
}
