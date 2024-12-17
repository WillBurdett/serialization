package main;

import java.io.IOException;
import main.models.Address;
import main.models.Dog;
import main.models.Employee;
import main.models.Person;
import main.services.SerializationScenarios;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

    Dog dog = new Dog("Jeff", 4);

    SerializationScenarios.basicScenario(dog, true);

    Person p = new Person();
    p.setAge(15);
    p.setName("Joe");

    Address a = new Address();
    a.setHouseNumber(1);

    Employee e = new Employee();
    e.setPerson(p);
    e.setAddress(a);

    SerializationScenarios.customScenario(e,true);
  }
}
