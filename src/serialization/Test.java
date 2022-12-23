package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test {
    public static void main(String[] args) throws IOException {
        Person person = new Person ("Libi", 26);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Serialization.txt"))){
            out.writeObject(person);
        } catch (Exception e) {
        }

    }
    private static class Person implements Serializable {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }

}
