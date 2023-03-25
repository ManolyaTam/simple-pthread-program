package simple.pthread.program;

import java.util.ArrayList;

public class thread extends Thread {

    ArrayList<Integer> arr = new ArrayList<>();
    int sum = 0;
    String threadName;

    public thread(ArrayList<Integer> arr, String threadName) {
        this.arr = arr;
        this.threadName = threadName;
        myUtil.printMessage("initializing thread " + threadName);
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        try {
            System.out.println("in thread");
            for (int i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
            }
            System.out.println("sum from " + threadName + " = " + sum);
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }
    }
}
