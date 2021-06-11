package ua.ithillel.task1;

import java.io.*;
import java.nio.file.Path;

public class Task1 {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Ivan", 964523145, "Kyiv-210, str. Lomonosova, 36");

        Path path = Path.of("./employee.ser");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(employee);
            oos.flush();
            System.out.println("\nEmployee saved to file.");
        } catch (IOException ioException) {
            System.out.println("\nSaved error. Employee not saved!");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Employee employFromFile = (Employee) ois.readObject();
            System.out.println("\nRead Employee from file:\n" + employFromFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\nRead ERROR.");
        }
    }
}
