package com.refactoringexample.my;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClient;
import com.mongodb.DB;

public class A extends ASuper {


    private B myB;
    private int x;

    public A(B abc, int x) {
        myB = abc;
        this.x = x;

    }

    int dosomethingWithX(){
        return x;
    }

    int doX() {
        return myB.getThis();
    }

    int getBigBigWhatever() {
        int x = doX();
        return x;
    }

    @Override
    int getFromStatic(){
        return getThisUnbelievableData();
    }

    static int getThisUnbelievableData(){
        //this code doesn't really work. It just compiles
        MongoClient mongoClient = new MongoClient();
        com.mongodb.client.MongoDatabase db = mongoClient.getDatabase("database name");
        String options = db.getName();

        return options.length();

    }
}
