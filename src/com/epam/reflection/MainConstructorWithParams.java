package com.epam.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MainConstructorWithParams {
    public static void main(String[] args) {
        MyClass myClass = null;
        String name = null;

        try {
            Class clazz = Class.forName(MyClass.class.getName());
            Class[] params = { int.class, String.class };
            myClass = (MyClass) clazz.getConstructor(params).newInstance(1, "default2");

            Field field = clazz.getDeclaredField("name");

            field.setAccessible(true);

            name = (String) field.get(myClass);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        int number = myClass.getNumber();

        System.out.println(number + name);//output created object reflection.MyClass@60e53b93
    }
}
