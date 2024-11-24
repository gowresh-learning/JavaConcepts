package org.example.concepts;

public class CallByValue_CallByReference {
    public String name;

    public static void modifyValue(int num) {
        num = 20; // Modifies the local copy, not the original x
        System.out.println("Inside method: " + num);
    }

    public static void modifyObject(CallByValue_CallByReference object)
    {
        object.name = "Bob"; // Modifies the original object
        System.out.println("Inside method: " + object.name);
    }

    public CallByValue_CallByReference(String name)
    {
        this.name = name;
    }
}
