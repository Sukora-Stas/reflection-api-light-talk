package com.epam.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainMethod {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        int number = myClass.getNumber();
        String name = null; //no getter =(

        printData(myClass);//output 0default

        //Reflection API – the dark side of java
        try {
            Field field = myClass.getClass().getDeclaredField("name");

            field.setAccessible(true);

            field.set(myClass, "new value");

            name = (String) field.get(myClass);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        printData(myClass); //output 0new value
    }

    //Reflection API – the dark side of java
    public static void printData(Object myClass){
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

