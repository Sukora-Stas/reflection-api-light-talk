package com.epam.reflection;

public class MainConstructor {
    public static void main(String[] args) {
        MyClass myClass = null;
        try {
            Class clazz = Class.forName(MyClass.class.getName());
            myClass = (MyClass) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);//output created object com.epam.reflection.MyClass@7c30a502
    }

}
