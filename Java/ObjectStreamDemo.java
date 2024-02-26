package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable{
    Integer id;

    String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
   
}

public class ObjectStreamDemo {

    private static final String path = "C:/Users/POT31166/Documents/core-java/resources/Employee.txt";
   
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        List<Employee> employees = List.of(new Employee(1, "Rajasekar"),
                new Employee(2, "Balu"));
                saveObjectToFile(employees, new File(path) );

            System.out.println("Read Object");
            System.out.println("Read object: " + readObjectToFile(new File(path)));    
       
    }

    public static void saveObjectToFile(List<Employee> employees, File file) throws FileNotFoundException, IOException {
        var objOutStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        try (objOutStream) {
            for (Employee emp : employees) {
                objOutStream.writeObject(emp);
            }
        }
    }

    public static List<Employee> readObjectToFile(File srcFile) throws FileNotFoundException,
     IOException, ClassNotFoundException {
        var objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(srcFile)));
        var employees = new ArrayList<Employee>();
        try (objectInputStream) {
            while(true) {
              var obj = objectInputStream.readObject();
              if (obj instanceof Employee) {
                    employees.add((Employee)obj);
              }
            }

        } catch (EOFException eof) {
            System.out.println("EOF is reached");
        }
        return employees;    
    }
}
