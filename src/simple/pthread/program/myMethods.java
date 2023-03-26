package simple.pthread.program;

import java.util.ArrayList;

public class myMethods {

    /**
     * sums up the array using 1 thread only
     *
     * @param nums
     * @return
     */
    public static int method1(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

    /**
     * sums up the array using 2 symmetric arrays
     *
     * @param nums
     * @return
     */
    public static int method2(ArrayList<Integer> nums) {
        int sum = 0;
        System.out.println("arr = " + nums.toString());
        ArrayList<Integer> arr1 = new ArrayList<Integer>(nums.subList(0, nums.size() / 2));
        System.out.println("arr1: " + arr1.toString());

        ArrayList<Integer> arr2 = new ArrayList<Integer>(nums.subList(nums.size() / 2, nums.size()));
        System.out.println("arr2: " + arr2.toString());
        try {
            thread t1 = new thread(arr1, "t1");
            t1.start();

            thread t2 = new thread(arr2, "t2");
            t2.start();

            boolean[] added = new boolean[]{false, false};
            while (!added[0] || !added[1]) {
                System.out.print("🤔");
                if (!added[0] && !t1.isAlive()) {
                    sum += t1.getSum();
                    added[0] = true;
                }
                if (!added[1] && !t2.isAlive()) {
                    sum += t2.getSum();
                    added[1] = true;
                }
            }
            return sum;
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }

        return -1; // if we get -1 as a sum, something must have gone wrong 
    }

    public static int method3(ArrayList<Integer> nums) {
        int sum = 0;
        System.out.println("arr = " + nums.toString());
        ArrayList<Integer> arr1 = new ArrayList<Integer>(nums.subList(0, nums.size() / 3));
        System.out.println("arr1: " + arr1.toString());

        ArrayList<Integer> arr2 = new ArrayList<Integer>(nums.subList(nums.size() / 3, nums.size()));
        System.out.println("arr2: " + arr2.toString());
        try {
            thread t1 = new thread(arr1, "t1");
            t1.start();

            thread t2 = new thread(arr2, "t2");
            t2.start();

            boolean[] added = new boolean[]{false, false};
            while (!added[0] || !added[1]) {
                System.out.print("🤔");
                if (!added[0] && !t1.isAlive()) {
                    sum += t1.getSum();
                    added[0] = true;
                }
                if (!added[1] && !t2.isAlive()) {
                    sum += t2.getSum();
                    added[1] = true;
                }
            }
            return sum;
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }

        return -1;
    }

    public static int method4(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

    public static int method5(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }
}
