import java.io.*; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 
class Student implements Serializable 
{ 
  private static final long serialVersionUID = 1L; 
  int id; 
  String name; double gpa; 
  public Student(int id, String name, double gpa) 
  { this.id = id; 
    this.name = name; 
    this.gpa = gpa; 
  } 
  @Override public String toString() 
  { 
      return "Student ID: " + id + ", Name: " + name + ", GPA: " + gpa; 
  } 
} 
public class StudentManagement 
{ 
    private static final String FILE_NAME = "students.ser"; 
    private static final Scanner scanner = new Scanner(System.in); 
    private static List<Student> students = new ArrayList<>(); 
    public static void serializeStudents() 
    { 
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) 
      { 
          oos.writeObject(students); 
          System.out.println("All students serialized successfully!"); 
      } 
      catch (IOException e) 
      { 
          System.out.println("Error during serialization: " + e.getMessage()); 
      } 
    } 
 public static void deserializeStudents() 
 { try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) 
  { 
      students = (List<Student>) ois.readObject(); 
      System.out.println("\nDeserialized Student List:"); 
      for (Student student : students) 
      { 
          System.out.println(student); 
      } 
      
  } 
  catch (FileNotFoundException e) 
  { 
      System.out.println("File not found! Please add students first."); 
      
  } 
  catch (IOException | ClassNotFoundException e) 
  { 
      System.out.println("Error during deserialization: " + e.getMessage()); 
      
  } 
 } 
 public static void main(String[] args) 
 { 
     while (true) 
     { 
         System.out.println("\n1. Add Student\n2. Display Students\n3. Exit");
         System.out.print("Choose an option: "); 
         int choice = scanner.nextInt(); 
         switch (choice) 
         { 
             case 1 -> 
         { 
             System.out.print("Enter Student ID: "); 
             int id = scanner.nextInt(); 
             scanner.nextLine();
             System.out.print("Enter Student Name: "); 
             String name = scanner.nextLine(); 
             System.out.print("Enter Student GPA: "); 
             double gpa = scanner.nextDouble(); 
             students.add(new Student(id, name, gpa)); 
             serializeStudents(); 
         } 
         case 2 -> deserializeStudents(); 
         case 3 -> 
         { 
             System.out.println("Exiting..."); 
             scanner.close(); 
             System.exit(0); 
         } 
         default -> System.out.println("Invalid choice! Try again."); 
} } } } 
