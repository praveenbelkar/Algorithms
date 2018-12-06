package com.algorithm.praveen.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class InheritanceSerialization {
    class A implements Serializable
    {
        Integer i;

        // parameterized constructor
        public A(Integer i)
        {
            System.out.println("Public constructor of A");
            this.i = i;
        }

        public A() {

        }

 /*       private void writeObject(ObjectOutputStream oos) {
            System.out.println("A: serialization..");
        }

        private A readObject(ObjectInputStream ois) {
            System.out.println("A: Deserialization...");
            A a = new A();
            a.i = 999;
            return a;
        }
*/
    }

    class C extends A {
        int k;

        public C(int i, int k){
            super(i);
            this.k = k;
            System.out.println("Non-default constructor of C");
        }

        public C(){
            //super(20);
            //k = 30;
            System.out.println("Default Constructor of C");
        }
    }

    // subclass B
// B class doesn't implement Serializable
// interface.
    class B extends C
    {
        int j;

        // parameterized constructor
        public B(int i, int j, int k)
        {
            super(i,k);
            this.j = j;
        }

        public B(){

        }
    }

    class D {
        String val;
    }

    public void testInheritance() throws IOException, ClassNotFoundException {
        //B b1 = new B(10, 20, 25);
        B b1 = new B();
        b1.i = 10;
        b1.j=20;
        b1.k=25;

        System.out.println("i = " + b1.i);
        System.out.println("j = " + b1.j);
        System.out.println("k = " + b1.k);

        /* Serializing B's(subclass) object */

        //Saving of object in a file
        FileOutputStream fos = new FileOutputStream("abc1.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        D d1 = new D();
        // Method for serialization of B's class object
        oos.writeObject(d1);

        // closing streams
        oos.close();
        fos.close();

        System.out.println("Object has been serialized");

        /* De-Serializing B's(subclass) object */

        // Reading the object from a file
        FileInputStream fis = new FileInputStream("abc1.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Method for de-serialization of B's class object
        //B b2 = (B) ois.readObject();
        D d2 = (D) ois.readObject();

        // closing streams
        ois.close();
        fis.close();

        System.out.println("Object has been deserialized");

        /*System.out.println("i = " + b2.i);
        System.out.println("j = " + b2.j);
        System.out.println("k = " + b2.k);*/
        System.out.println("d="+d2.val);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InheritanceSerialization mainObject = new InheritanceSerialization();
        mainObject.testInheritance();
    }
}

