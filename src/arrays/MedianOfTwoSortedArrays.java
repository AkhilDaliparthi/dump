package arrays;

//https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int target = (nums1.length+nums2.length)%2==0  ? ((nums1.length+nums2.length)/2)-1 : (nums1.length+nums2.length)/2;
        int kElement = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        while(k<=target && i<nums1.length && j<nums2.length) {
            if(nums1[i]<=nums2[j]) {
                kElement = nums1[i];
                i++;
            } else {
                kElement = nums2[j];
                j++;
            }
            k++;
        }
        while(k<=target && i<nums1.length) {
            kElement = nums1[i];
            i++;
            k++;
        }
        while(k<=target && j<nums2.length) {
            kElement = nums2[j];
            j++;
            k++;
        }
        if((nums1.length+nums2.length)%2==0) {
            if(i<nums1.length && j<nums2.length) {
                return ((double) (kElement + (Math.min(nums1[i], nums2[j]))))/2;
            } else {
                if (i<nums1.length) {
                    return ((double) (kElement + nums1[i]))/2;
                }
                return ((double) (kElement + nums2[j]))/2;
            }
        } else {
            return  kElement;
        }
    }

    public static void main (String[] args) {

        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.print(motsa.findMedianSortedArrays(nums1, nums2));
    }
}
