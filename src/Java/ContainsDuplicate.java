package Java;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 4};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        if (nums.length == 0)
            return false;

        HashMap<Integer, Integer> freqTable = new HashMap<>();

        for (int num : nums) {
            freqTable.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : freqTable.entrySet()) {
            if (integerIntegerEntry.getValue() > 1)
                return true;
        }
        return false;
    }
}