package main.models;

import java.io.Serializable;

public class Person implements Serializable {

  private int age;
  private String name;
  private transient Address country; // must be serializable too

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getCountry() {
    return country;
  }

  public void setCountry(Address country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Person{" +
        "age=" + age +
        ", name='" + name + '\'' +
        ", country=" + country +
        '}';
  }
}
