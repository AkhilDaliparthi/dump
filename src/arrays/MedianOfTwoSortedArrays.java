package arrays;

public class MedianOfTwoSortedArrays {

    public double solution(int[] arr1, int[] arr2, int m, int n) {
        if(m>n)
            return solution(arr2,arr1,n,m);//ensuring that binary search happens on minimum size array

        int low=0,high=m,medianPos=((m+n)+1)/2;
        while(low<=high) {
            int cut1 = low+(high-low)/2;
            int cut2 = medianPos - cut1;

            int l1 = (cut1 == 0)? Integer.MIN_VALUE:arr1[cut1-1];
            int l2 = (cut2 == 0)? Integer.MIN_VALUE:arr2[cut2-1];
            int r1 = (cut1 == m)? Integer.MAX_VALUE:arr1[cut1];
            int r2 = (cut2 == n)? Integer.MAX_VALUE:arr2[cut2];

            if(l1<=r2 && l2<=r1) {
                if((m+n)%2 != 0)
                    return Math.max(l1,l2);
                else
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2) high = cut1-1;
            else low = cut1+1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {-5, 3, 6, 12, 15};
        int[] nums2 = {-12, -10, -6, -3, 4, 10};
        System.out.println(medianOfTwoSortedArrays.solution(nums1, nums2, nums1.length, nums2.length));
    }
}
