package simple.pthread.program;

import java.util.ArrayList;

public class thread extends Thread {

    int sum = 0;
    String threadName;
    int start; // index 
    int end;
    int i1;
    int i2;
    int i3;
    int i4;

    public thread(int start, int end, String threadName) {
        this.start = start;
        this.end = end;
        this.threadName = threadName;
//        myUtil.printMessage("initializing thread " + threadName, "green");
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        try {
            myUtil.printMessage("\nstarting thread " + threadName);
            for (int i = start; i < end; i++) {
                sum += SimplePthreadProgram.nums.get(i);
            }
            myUtil.printMessage("\nsum from " + threadName + " = " + sum);
        } catch (Exception e) {
            myUtil.printMessage(e.toString(), "red");
        }
    }

}
