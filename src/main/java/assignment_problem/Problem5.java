package assignment_problem;

import java.util.HashSet;
public class Problem5 {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (set.contains(complement)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println(hasPairWithSum(nums1, target1));
        System.out.println(hasPairWithSum(nums2, target2));
    }
}
