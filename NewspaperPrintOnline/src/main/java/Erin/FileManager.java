package Erin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String USERS_FILE = "users.bin";
    private static final String ADS_FILE = "ads.bin";
    private static final String POSTS_FILE = "posts.bin";



    @SuppressWarnings("unchecked")
    public static List<User> loadUsers() {
        File file = new File(USERS_FILE);
        if (!file.exists()) {

            List<User> initialUsers = new ArrayList<>();
            initialUsers.add(new Advertiser("adv1", "pass1", "TechCorp Inc.", "5551234"));
            initialUsers.add(new SocialMediaManager("smm1", "pass1"));
            saveUsers(initialUsers);
            return initialUsers;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @SuppressWarnings("unchecked")
    public static List<Advertisement> loadAdvertisements() {
        File file = new File(ADS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Advertisement>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveAdvertisements(List<Advertisement> ads) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ADS_FILE))) {
            oos.writeObject(ads);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    public static List<SocialMediaPost> loadPosts() {
        File file = new File(POSTS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<SocialMediaPost>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void savePosts(List<SocialMediaPost> posts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(POSTS_FILE))) {
            oos.writeObject(posts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}