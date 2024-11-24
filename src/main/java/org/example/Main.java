package org.example;

import org.example.concepts.CallByValue_CallByReference;
import org.example.concepts.SingletonPattern;
public class Main {
    public static void main(String[] args) {

        /**
         * Wrapper Classes
         */
        String stringVariable = "100";
        int integerVariable  = Integer.parseInt(stringVariable); //NumberFormatException
        double doubleVaribale = Double.parseDouble("12.33");
        boolean booleanVariable = Boolean.parseBoolean("true");
        String integerVariable1 = String.valueOf(10);
        System.out.println(integerVariable + 100 + integerVariable1);
        System.out.println(doubleVaribale + 10.77);
        System.out.println(booleanVariable);
        /**
         * Call By Value & Call By Reference
         */
        //In Call By Value, the actual value of the argument is passed to the method. This means that
        // any changes made to the parameter inside the method do not affect the original value outside the method.
        int x = 10;
        System.out.println("Before method call: " + x);
        CallByValue_CallByReference.modifyValue(x); // Passing the value of x
        System.out.println("After method call: " + x); // Value of x outside method remains the same
        //In Call By Reference, the reference (memory address) of the argument is passed to the method.
        // This means that if the object is modified inside the method, the changes will affect the original object
        // outside the method as well.
        CallByValue_CallByReference p = new CallByValue_CallByReference("Alice");
        System.out.println("Before method call: " +p.name);
        p.modifyObject(p); // Passing the reference of the object
        System.out.println("After method call: " + p.name); // Object's name is modified
        /**
         * Singleton Pattern
         **/
        //SingletonPattern Instantiate the object only once
        SingletonPattern first_singletonPatternObject = SingletonPattern.getInstance();
        first_singletonPatternObject.displayMssg();
        SingletonPattern second_singletonPatternObject = SingletonPattern.getInstance();
        second_singletonPatternObject.displayMssg();
        //Multiple thread behaviour
        Runnable task = () -> {
            SingletonPattern singletonPattern = SingletonPattern.getInstance();
            singletonPattern.displayMssg();
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.start();thread2.start();thread3.start();
        //wait for all threads to complete
        try{ thread1.join();thread2.join();thread3.join();}
        catch(InterruptedException e){e.printStackTrace();}

    }
}