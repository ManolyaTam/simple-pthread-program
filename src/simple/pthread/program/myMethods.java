package simple.pthread.program;

import java.util.ArrayList;

public class myMethods {

    /**
     * sums up the array using 1 thread only
     *
     * @param nums
     * @return
     */
    public static int method1() {
        long StartTime = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < SimplePthreadProgram.arraySize; i++) {
            sum += SimplePthreadProgram.nums.get(i);
        }
        long stopTime = System.nanoTime();
        System.out.println("time it took = " + (stopTime - StartTime) + " nanoseconds");
        return sum;
    }

    /**
     * sums up the array using 2 symmetric arrays
     *
     * @param nums
     * @return
     */
    public static int method2() {
        long StartTime = System.nanoTime();
        int sum = 0;

        try {
            thread t1 = new thread(0, SimplePthreadProgram.arraySize / 2, "t1");
            t1.start();

            thread t2 = new thread(SimplePthreadProgram.arraySize / 2, SimplePthreadProgram.arraySize, "t2");
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
            long stopTime = System.nanoTime();
            System.out.println("time it took = " + (stopTime - StartTime) + " nanoseconds");
            return sum;
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }

        return -1; // if we get -1 as a sum, something must have gone wrong 
    }

    public static int method3() {
        long StartTime = System.nanoTime();
        int sum = 0;

        try {
            thread t1 = new thread(0, SimplePthreadProgram.arraySize / 3, "t1");
            t1.start();

            thread t2 = new thread(SimplePthreadProgram.arraySize / 3, SimplePthreadProgram.arraySize, "t2");
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
            long stopTime = System.nanoTime();
            System.out.println("time it took = " + (stopTime - StartTime) + " nanoseconds");
            return sum;
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }

        return -1;
    }

    public static int method4() {
        long StartTime = System.nanoTime();
        int sum = 0;

        try {
            thread t1 = new thread(0, SimplePthreadProgram.arraySize / 4, "t1");
            t1.start();

            thread t2 = new thread(SimplePthreadProgram.arraySize / 4, SimplePthreadProgram.arraySize / 2, "t2");
            t2.start();

            thread t3 = new thread(SimplePthreadProgram.arraySize / 2, 3 * SimplePthreadProgram.arraySize / 4, "t3");
            t3.start();

            thread t4 = new thread(3 * SimplePthreadProgram.arraySize / 4, SimplePthreadProgram.arraySize, "t4");
            t4.start();

            boolean[] added = new boolean[]{false, false, false, false};
            while (!added[0] || !added[1] || !added[2] || !added[3] ) {
                System.out.print("🤔");
                if (!added[0] && !t1.isAlive()) {
                    sum += t1.getSum();
                    added[0] = true;
                }
                if (!added[1] && !t2.isAlive()) {
                    sum += t2.getSum();
                    added[1] = true;
                }
                if (!added[2] && !t3.isAlive()) {
                    sum += t3.getSum();
                    added[2] = true;
                }
                if (!added[3] && !t4.isAlive()) {
                    sum += t4.getSum();
                    added[3] = true;
                }
            }
            long stopTime = System.nanoTime();
            System.out.println("time it took = " + (stopTime - StartTime) + " nanoseconds");
            return sum;
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }

        return -1;
    }

    public static int method5(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }
}
