package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length < 3){
            return -1;
        }

        int tempRightSum = 0;
        int tempLeftSum = 0;
        for(int value : nums){
            tempRightSum += value;
        }
        tempRightSum -= nums[0];

        for(int i = 0; i < nums.length; i++){
            if(tempLeftSum == tempRightSum){
                return i;
            }else{
                tempLeftSum += nums[i];
                if( i + 1 < nums.length){
                    tempRightSum -= nums[i + 1];
                }
            }
        }
        return -1;
    }
/*
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            int current = nums[i];
            int left = 0;
            int li = i;
            int ri = i;
            while (--li >= 0) {
                left += nums[li];
            }
            int right = 0;
            while (++ri < nums.length) {
                right += nums[ri];
            }
            if (left == right) {
                return i;
            }

        }
        return -1;
    }
*/
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().pivotIndex(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}