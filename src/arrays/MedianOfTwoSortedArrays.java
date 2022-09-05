package arrays;

public class MedianOfTwoSortedArrays {

    public double solution(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0) {
            return 0;
        }
        if(nums1.length==0) {
            return nums2[(nums2.length-1)/2]*0.5 + nums2[(nums2.length/2)]*0.5;
        }

        if(nums1.length==0) {
            return nums2[(nums2.length-1)/2]*0.5 + nums2[(nums2.length/2)]*0.5;
        }

        if(nums1.length>nums2.length) {
          return solution(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high =m;
        while(low<high) {
            int mid1 = low + (high-low)/2;
            int mid2 = (n+m)/2 - mid1;
            if(nums1[mid1]<nums2[mid2-1]) {
                low = mid1+1;
            } else {
                high = mid1;
            }
        }
        int first = low;
        int second = (n+m)/2 - low;

        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];

        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];

        if((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        }else{
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6};
        System.out.println(medianOfTwoSortedArrays.solution(nums1, nums2));
    }
}
