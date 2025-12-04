package Mafin.Reader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DummyObjects {
    public void createDummyObjects(){
        Reader r1 = new Reader ("123", "tashnia", "01876347652", "tashnia@gmail.com", "tinka2025", "Online");
        try {
            FileOutputStream fos = new FileOutputStream("Reader.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(r1);
            oos.close();
        } catch (Exception e) {
            //
        }
    }
}
