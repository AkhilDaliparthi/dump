package arrays;

public class MaxDistance {

    public int maximumGap(final int[] A) {
        int maxDiff;
        int i, j;

        int n = A.length;
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = A[0];

        for (i = 1; i < n; ++i) {
            LMin[i] = Math.min(A[i], LMin[i - 1]);
        }

        RMax[n - 1] = A[n - 1];
        for (j = n - 2; j >= 0; --j) {
            RMax[j] = Math.max(A[j], RMax[j + 1]);
        }

        i = 0; j = 0; maxDiff = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.maximumGap(new int[]{3, 5, 4, 2}));
    }
}
