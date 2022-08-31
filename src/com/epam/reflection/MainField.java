package com.epam.reflection;

import java.lang.reflect.Field;

public class MainField {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        int number = myClass.getNumber();
        String name = null; //no getter =(

        System.out.println(number + name);//output 0null

        //Reflection API – the dark side of java
        try {
            Field field = myClass.getClass().getDeclaredField("name");

            field.setAccessible(true);

            field.set(myClass, "new value");

            name = (String) field.get(myClass);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(number + name); //output 0new value
    }

}

