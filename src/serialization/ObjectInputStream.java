//package serialization;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.Serializable;
//
//public class ObjectInputStream {
//    public static void main(String[] args) throws IOException {
//        Person person = null;
//
//        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Serialization.txt"))){
//            person = (Person) in.readObject();
//        } catch (Exception e) {
//        }
//
//        System.out.println(person.toString());
//
//    }
//    private static class Person implements Serializable {
//        String name;
//        int age;
//
//        public Person(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        @Override
//        public String toString() {
//            return "Person [name=" + name + ", age=" + age + "]";
//        }
//    }
//}
