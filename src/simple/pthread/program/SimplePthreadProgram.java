package simple.pthread.program;

import java.util.Scanner;
import java.util.ArrayList;

public class SimplePthreadProgram {
    public static int arraySize = 1000000;
    public static ArrayList<Integer> nums;
    
    private static ArrayList<Integer> generateArray() {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < arraySize; i++) {
            arr.add((int) Math.floor(Math.random() * 100));
        }
        return arr;
    }

    private static int promptUser() {
        int response = -1;
        do {
            if (response == -1) {
                myUtil.printMessage("WELCOME TO MY SIMPLE PTHREAD PROGRAM!", "green");
                myUtil.printMessage("HERE, YOU CAN CHOOSE DIFFERENT METHODS TO SUM UP THE RANDOM VALUES OF A 1 MILLION LENGTH ARRAY", "green");
            } else {
                myUtil.printMessage("please enter a number between 1 and 5", "red");
            }
            System.out.println("0: Try all methods on same generated array");
            System.out.println("1: Use 1 thead only");
            System.out.println("2: Use 2 Symmetric threads");
            System.out.println("3: Use 2 Aymmetric threads");
            System.out.println("4: Use 4 Symmetric threads");
            System.out.println("5: Use 4 Asymmetric threads");
            System.out.print("your answer: ");
            Scanner scanner = new Scanner(System.in);
            response = Integer.parseInt(scanner.nextLine());
        } while (response < 0 || response > 5);
        return response;
    }

    private static void useMethod(int method) {
        myUtil.printMessage("---------------------------------------", "green");
        int sum = -1;
        switch (method) {
            case 0:
                myUtil.printMessage("\t\t1) Using 1 thead only", "green");
                sum = myMethods.method1();
                
                myUtil.printMessage("\t\t2) Using 2 Symmetric threads", "green");
                sum = myMethods.method2();
                
                myUtil.printMessage("\t\t3) Using 2 Aymmetric threads", "green");
                sum = myMethods.method3();
                
                myUtil.printMessage("\t\t4) Using 4 Symmetric threads", "green");
                sum = myMethods.method4();
                
                myUtil.printMessage("\t\t5) Use 4 Asymmetric threads", "green");
                sum = myMethods.method5();
                break;
            case 1:
                sum = myMethods.method1();
                break;
            case 2:
                sum = myMethods.method2();
                break;
            case 3:
                sum = myMethods.method3();
                break;
            case 4:
                sum = myMethods.method4();
                break;
            case 5:
                sum = myMethods.method3();
                break;
        }
        if (sum == -1) {
            myUtil.printMessage("\nsomething went wrong!", "red");
        } else {
            myUtil.printMessage("\nTotal : " + sum, "green");
        }
    }

    public static void main(String[] args) {
        nums = generateArray();
        int response = promptUser();

        useMethod(response);
    }
}
