package udemy.arrays;

public class Rains {

    public int solution(int[] height) {
        int area = 0;
        if(height.length > 2) {
            int left = 1;
            int right = height.length - 2;
            int leftMax = height[0];
            int rightMax = height[height.length-1];
            while(left<=right) {
                if(leftMax < rightMax) {
                    if(height[left]<leftMax) {
                        area += leftMax - height[left];
                        left++;
                    } else {
                        leftMax = height[left];
                        left++;
                    }
                } else {
                    if(height[right]<rightMax) {
                        area += rightMax - height[right];
                        right--;
                    } else {
                        rightMax = height[right];
                        right--;
                    }
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Rains rains = new Rains();
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(rains.solution(input));
    }
}
