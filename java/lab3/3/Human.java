import java.util.*;

class Human implements Comparable<Human> {
    String name, lastName;
    int age;
    
    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
       
    public int compareTo(Human otherHuman) {
        int result = this.lastName.compareTo(otherHuman.lastName);
        return result != 0 ? result : this.name.compareTo(otherHuman.name);
    }
    
    public String toString() {
        return name + " " + lastName + " (" + age + ")";
    }

    public String getLastName() { return lastName; }
    public int getAge() { return age; }
}

class HumanComparatorByLastName implements Comparator<Human> {
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}


    
