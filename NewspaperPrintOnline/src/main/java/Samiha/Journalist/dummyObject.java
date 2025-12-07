package Samiha.Journalist;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class dummyObject implements Serializable {
    public void createDummyObjects() {
     Journalist j1 = new Journalist("12345", "Samiha", "092863463", "samiha@gmail.com", "55555","Journalist");
        try {
        FileOutputStream fos = new FileOutputStream("Journalist.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(j1);
        oos.close();
        }catch (Exception e) {
        //
        }
}}
