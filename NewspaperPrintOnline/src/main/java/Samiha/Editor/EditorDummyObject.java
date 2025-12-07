package Samiha.Editor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EditorDummyObject implements Serializable {

    public void createDummyObjects() {

        Editor e1 = new Editor("123456", "Samiiha", "0928634638",
                "samiiha@gmail.com", "666666", "Editor");

        try {
            FileOutputStream fos = new FileOutputStream("Editor.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(e1);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
