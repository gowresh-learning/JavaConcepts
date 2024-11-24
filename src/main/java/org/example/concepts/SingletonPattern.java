package org.example.concepts;

import java.util.Random;

public class SingletonPattern {

    //1. Private static instance of the class
    //When a variable is marked as volatile, it ensures that its value is always fetched from and written directly to the main memory,
    //and not cached in a thread’s local cache or CPU register. This guarantees that all threads see the most up-to-date value of the variable.
    private volatile static SingletonPattern sIngletonPattern;

    //2. Private constructor to prevent/avoid instantiation/object
    private SingletonPattern(){
        if(sIngletonPattern != null)
        {
            throw new IllegalArgumentException("Hey you cant create me without me creating myself"); // protect from reflection attacks
        }
    }

    //3. Public static method to provide access to the instance/object
    //synchronized: means first thread will lock & use and then the next thread will use & lock
    public  synchronized static SingletonPattern getInstance(){
        if(sIngletonPattern == null){
            sIngletonPattern = new SingletonPattern();
        }
        return sIngletonPattern;
    }

    //Individual public method of the class
    public  void  displayMssg()
    {
        System.out.println("Hey its me SingletonPattern and the variable check is set to :"+check+" and the hashcode is "+SingletonPattern.getInstance().hashCode() );
    }

    public  String check = new Random().nextDouble()+"";;
}
