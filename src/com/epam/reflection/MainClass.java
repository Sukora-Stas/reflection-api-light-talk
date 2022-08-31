package com.epam.reflection;

import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) {
        System.out.println(MyClass.class.getName()); //output com.epam.reflection.MyClass

        MyClass myClass = null;
        try {
            Class clazz = Class.forName(MyClass.class.getName());

            myClass = (MyClass) clazz.getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);//output com.epam.reflection.MyClass@7c30a502
    }

}

