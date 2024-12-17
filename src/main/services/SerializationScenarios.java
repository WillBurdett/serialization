package main.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import main.models.Dog;
import main.models.Employee;

public class SerializationScenarios {

  public static void basicScenario(Dog dog, boolean deleteFiles) throws IOException, ClassNotFoundException,
      InterruptedException {
    SerializationScenarios.basicSerialize(dog);
    printSetup("basic");
    SerializationScenarios.basicDeserialize(deleteFiles);
    printTeardown("basic");
  }

  public static void basicSerialize(Dog dog) throws IOException {
    FileOutputStream fileOutputStream
        = new FileOutputStream("basic-scenario.txt");
    ObjectOutputStream objectOutputStream
        = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(dog);
    objectOutputStream.flush();
    objectOutputStream.close();
  }

  public static void basicDeserialize(boolean deleteFiles) throws IOException, ClassNotFoundException, InterruptedException {
    FileInputStream fileInputStream
        = new FileInputStream("basic-scenario.txt");
    ObjectInputStream objectInputStream
        = new ObjectInputStream(fileInputStream);
    Dog dog = (Dog) objectInputStream.readObject();
    objectInputStream.close();
    printDeserializedEquals(dog);
    if (deleteFiles) {
      printDeletion("basic-scenario.txt");
    }
  }

  public static void customScenario(Employee e, boolean deleteFiles) throws IOException, ClassNotFoundException,
      InterruptedException {
    SerializationScenarios.customSerialize(e);
    printSetup("custom");
    SerializationScenarios.customDeserialize(deleteFiles);
    printTeardown("custom");
  }

  public static void customSerialize(Employee e) throws IOException {
    FileOutputStream fileOutputStream
        = new FileOutputStream("custom-scenario.txt");
    ObjectOutputStream objectOutputStream
        = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(e);
    objectOutputStream.flush();
    objectOutputStream.close();
  }

  public static void customDeserialize(boolean deleteFiles)
      throws IOException, ClassNotFoundException, InterruptedException {
    FileInputStream fileInputStream
        = new FileInputStream("custom-scenario.txt");
    ObjectInputStream objectInputStream
        = new ObjectInputStream(fileInputStream);
    Employee e = (Employee) objectInputStream.readObject();
    objectInputStream.close();
    printDeserializedEquals(e);
    if (deleteFiles) {
      printDeletion("custom-scenario.txt");
    }
  }

  private static void printSetup( String scenario) throws InterruptedException {
    System.out.println("--- " + scenario.toUpperCase(Locale.ROOT) + " SCENARIO STARTED ---");
    Thread.sleep(1500);
    System.out.println("Serialized file (byte stream) created...");
    Thread.sleep(1500);
    System.out.println("Pausing before deserialization...");
    Thread.sleep(1500);
  }

  private static void printTeardown(String scenario) throws InterruptedException {
    System.out.println("--- " + scenario.toUpperCase(Locale.ROOT) + " SCENARIO ENDED ---");
    System.out.println("\n");
    Thread.sleep(1500);
  }

  private static <T> void printDeserializedEquals(T obj) throws InterruptedException {
    System.out.println("Deserialized value =");
    Thread.sleep(1500);
    System.out.println(obj);
    Thread.sleep(1500);
  }

  private static void printDeletion(String path) throws IOException, InterruptedException {
    Files.delete(Path.of(path));
    System.out.println("Deleting files created.");
    Thread.sleep(1500);
  }

}
