import java.util.*;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * 
 * @author Michael Kolling and David Barnes
 * @version 2008.03.30
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    private List<Student> students;
    private int capacity;
    private int credits;
    private int total;
    private int counter;
    
    /**
     * Create a LabClass with a maximum number of enrolments. All other details
     * are set to default values.
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "unknown";
        room = "unknown";
        timeAndDay = "unknown";
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }
    

    /**
     * Add a student to this LabClass.
     */
    public void enrollStudent(Student newStudent)
    {
        if(students.size() == capacity) {
            System.out.println("The class is full, you cannot enrol.");
        }
        else {
            students.add(newStudent);
        }        
    }
    
    /**
     * Return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents()
    {
        return students.size();
    }
    
    /**
     * Set the room number for this LabClass.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }
    
    /**
     * Set the time for this LabClass. The parameter should define the day
     * and the time of day, such as "Friday, 10am".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }
    
    /**
     * Set the name of the instructor for this LabClass.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }
    
    public void autoLab() {
        setInstructor("Harry Richards");
        setRoom("CG66");
        setTime("Tuesday, 2pm");
        Student s1 = new Student("James Whittaker", "S00001", 190);
        Student s2 = new Student("John Smith", "S00002", 210);
        enrollStudent(s1);
        enrollStudent(s2);
        printList();
    }     
    
    public void setCapacity(int newCapacity)
    {
        capacity = newCapacity;
    }
    
    /**
     * Print out a class list with other LabClass details to the standard
     * terminal.
     */
    public void printList()
    {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor + "   room: " + room);
        System.out.println("Class list:");
        for(Student student : students) {
            student.print();
        }
        System.out.println("Number of students: " + numberOfStudents());
    }
    
    public void printCredits()
    {
        for(Student student : students) {
            student.print();
            credits = student.getCredits();
            System.out.println("Current credit total:" + credits);
            total += credits;
            counter += 1;
        }
        
        System.out.println();
        System.out.println("Average credits score:" + total/counter);
    }
}
