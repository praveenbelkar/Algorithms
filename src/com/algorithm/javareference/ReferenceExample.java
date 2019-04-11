package com.algorithm.javareference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceExample {

    class Person {
        int id;
    }

    public void phantomReference() {
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        Person person = new Person();
        PhantomReference<Person> phantomReference = new PhantomReference<>(person, referenceQueue);
        int cnt = 0;
        while (true) {
            cnt++;
            if(cnt > 5) {
                person = null;
                System.gc();
            }
            Reference<? extends Person> deletedPersonRef = referenceQueue.poll();
            if(deletedPersonRef != null) {
                System.out.println("person is deleted");
                break;
            }
            System.out.println("Person is not deleted yet..");
        }
    }

    public static void main(String[] args) {
        ReferenceExample mainObject = new ReferenceExample();
        mainObject.phantomReference();
    }
}
