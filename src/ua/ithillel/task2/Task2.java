package ua.ithillel.task2;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        Path path = Path.of("./users.ser");

        User[] users = new User[10];
        for (int i = 0; i < 10; i++) {
            int randomAge = 1 + (int) (Math.random() * 100);
            users[i] = new User("Name_" + (i + 1), "LastName_" + (i + 1), randomAge);
        }

        writeUsers(path, users);
        readUsers(path);
    }

    private static void readUsers(Path path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            try {
                User[] usersNew = (User[]) objectInputStream.readObject();
                System.out.println("\nExtracted users from file: " + Arrays.toString(usersNew));
            } catch (ClassNotFoundException e) {
                System.out.println("No definition for the class with the specified name could be found.");
            }
        } catch (IOException e) {
            System.out.println("I/O Error. Chek file path and file.");
        }
    }

    private static void writeUsers(Path path, User[] users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            System.out.println("I/O Error. Chek file path and file.");
        }
    }
}
