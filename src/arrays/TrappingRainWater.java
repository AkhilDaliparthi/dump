package arrays;

//https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {

    public int trap(int[] height) {
        int area = 0;
        if(height.length > 2) {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            int leftTempMax = 0;
            int rightTempMax = 0;
            for(int i=0; i<height.length; i++) {
                if(height[i] > leftTempMax) {
                    leftTempMax = height[i];
                   leftMax[i] =  leftTempMax;
                } else {
                    leftMax[i] = leftTempMax;
                }
                if(height[height.length-i-1] > rightTempMax) {
                    rightTempMax = height[height.length-i-1];
                    rightMax[height.length-i-1] = rightTempMax;
                } else {
                    rightMax[height.length-i-1] = rightTempMax;
                }
            }
            for(int i=1; i< height.length-1; i++) {
                int min = Math.min(leftMax[i], rightMax[i]);
                if(height[i] < min) {
                    area += min - height[i];
                }
            }
        }
        return area;
    }

    public int optimisedTrap(int[] height) {
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
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trappingRainWater.optimisedTrap(input));
    }
}
