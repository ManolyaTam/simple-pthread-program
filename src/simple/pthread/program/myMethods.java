package simple.pthread.program;

import java.util.ArrayList;

public class myMethods {

    public static int method1(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

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
            t1.join();
            sum += t1.getSum();

            thread t2 = new thread(arr2, "t2");
            t2.start();
            t2.join();
            sum += t2.getSum();

            return sum;
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }

        return -1; // if we get -1 as a sum, something must have gone wrong 
    }

    public static int method2Sum(int sum) {

        return 0;
    }

    public static int method3(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
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
