package array1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int max = 0;
        int smax = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = nums[i];
            } else if (i == 1) {
                if (nums[i] >= max) {
                    smax = max;
                    max = nums[i];
                    maxIndex = i;
                } else {
                    smax = nums[i];
                }
            } else {
                if (nums[i] > max) {
                    smax = max;
                    max = nums[i];
                    maxIndex = i;
                } else if (nums[i] > smax) {
                    smax = nums[i];
                }
            }
            if (i == nums.length - 1) {
                return max >= smax * 2 ? maxIndex : -1;
            }

        }

        return -1;
    }
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

            int ret = new Solution().dominantIndex(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}