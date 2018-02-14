package com.refactoringexample.my;

public class mySingleton {
    private static mySingleton instance = null;
    protected mySingleton() {
        
    }
    public static mySingleton getInstance() {
        if(instance == null) {
            instance = new mySingleton();
        }
        return instance;
    }
}
