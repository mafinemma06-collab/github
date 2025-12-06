package Mafin.Reader;

import Mafin.Publisher.Publisher;

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
        Publisher p1 = new Publisher ("2222", "jungkook", "01780716615", "jungkook@gamil.com","mafin");
        try {
            FileOutputStream fos = new FileOutputStream("Publisher.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(p1);
            oos.close();
        } catch (Exception e) {
            //
        }

        article art1 = new article("1", "Earthquake", "news", "More jaba shobai");
        article art2 = new article("2", "Tsunami", "sports", "Abr morba");
        article art3 = new article("3","Rain","weather", "rain rain go away");
        try{
            FileOutputStream fos1 = new FileOutputStream("article.bin");
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

            oos1.writeObject(art1);
            oos1.writeObject(art2);
            oos1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        subscription sub1 = new subscription(2000, "not much","monthly");
        subscription sub2 = new subscription(5000, "many","yearly");
        try{
            FileOutputStream fos2 = new FileOutputStream("subscription.bin");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

            oos2.writeObject(sub1);
            oos2.writeObject(sub2);
            oos2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        GenericFileManager.append(sub1, "subscription.bin");
//        GenericFileManager.append(sub2, "subscription.bin");

        //GenericFileManager.append(art1, "article.bin");
        //GenericFileManager.append(art2, "article.bin");

    }
}
