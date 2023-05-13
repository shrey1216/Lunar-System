//@author Shreyan Wankavala
//112634232
//Recitation 01

import java.io.*;
import java.util.*;


public class LunarSystem {

    public static void main(String[]args){

        System.out.println("\nWelcome to the Lunar System, a second place course registration system for second rate courses at a second class school.");

        Scanner scan = new Scanner(System.in);
        HashMap<String,Student> students = new HashMap<String,Student>();
        ArrayList<Student> classTable = new ArrayList<>();
        Student[] temp1;

        try{
            students = readFile();
        }catch(ClassNotFoundException | IOException e){
            System.out.println("\nNo previous data found.\n");
        }

        String op1 = "";

        while(!(op1.equals("Q") || op1.equals("X"))){
            System.out.print("\nMenu:" +
                    "\n" +
                    "    L)Login\n" +
                    "    X)Save state and quit\n" +
                    "    Q)Quit without saving state\n");
            System.out.print("\nPlease select an option:");
            op1 = scan.nextLine().toUpperCase();
            switch(op1){
                case "L":
                    System.out.print("Please enter webID:");
                    String webID = scan.nextLine();
                    if(webID.length() <= 2){
                        System.out.print("\nThis is not a valid webID! Try again.\n");
                        continue;
                    }
                    if(webID.equals("REGISTRAR") || webID.equals("Registrar") || webID.equals("registrar")){
                        System.out.println("\nWelcome Registrar.");
                        System.out.print("\nOptions:\n" +
                                "     R) Register a student\n" +
                                "     D) De-register a student\n" +
                                "     E) View course enrollment\n" +
                                "     L) Logout");
                        String op2 = "";
                        while(!op2.equals("L")) {
                            System.out.print("\nPlease select an option:");
                            op2 = scan.nextLine().toUpperCase();
                            switch(op2){
                                case "R":
                                    System.out.print("Please enter a webID for the new student:");
                                    String studentID = scan.nextLine();
                                    if(studentID.length() <= 2){
                                        System.out.print("\nThis is not a valid webID! Try again.\n");
                                        continue;
                                    }
                                    Student stu = new Student();
                                    studentID = studentID.substring(0,2).toUpperCase() + studentID.substring(2).toLowerCase();
                                    if(!students.containsKey(studentID)) {
                                        stu.setWebID(studentID);
                                        students.put(studentID, stu);
                                        System.out.print(studentID + " registered.\n");
                                    }else{
                                        System.out.print(studentID + " is already registered.\n");
                                    }
                                    break;
                                case "D":
                                    System.out.print("Please enter a webID for the student to be de-registered:");
                                    studentID = scan.nextLine();
                                    studentID = studentID.substring(0,2).toUpperCase() + studentID.substring(2);
                                    if(students.containsKey(studentID)) {
                                        students.remove(studentID);
                                        System.out.print(studentID + " de-registered.\n");
                                    }else{
                                        System.out.print(studentID + " is not registered.\n");
                                    }
                                    break;
                                case "E":
                                    System.out.print("Please enter course:");
                                    String course = scan.nextLine().toUpperCase();
                                    if(course.length() != 7){
                                        System.out.print("That is not a valid course! Try again.\n");
                                        continue;
                                    }

                                    System.out.println("\nStudents registered in " + course + ":");
                                    System.out.println("Student    Semester");
                                    System.out.println("-------------------");

                                    temp1 = students.values().toArray(new Student[students.values().size()]);
                                    for(int i = 0; i < temp1.length; i++){
                                        classTable.add(temp1[i]);
                                    }

                                    for(int i = 0 ; i < classTable.size(); i++){
                                        for(int j = 0; j < classTable.get(i).getCourses().size(); j++) {
                                            if (classTable.get(i).getCourses().get(j).getDepartment().equals(course.substring(0, 3)) && classTable.get(i).getCourses().get(j).getNumber() == Integer.parseInt(course.substring(4))) {
                                                System.out.println(classTable.get(i).getWebID() + "    " + classTable.get(i).getCourses().get(j).getSemester());
                                            }
                                        }
                                    }
                                    classTable.clear();
                                    break;
                                case "L":
                                    System.out.println("Registrar logged out.");
                                    break;
                                default:
                                    System.out.println("\nThat is not a choice! Try again.\n");
                                    break;
                            }
                        }
                    }
                    else {
                        webID = webID.substring(0, 2).toUpperCase() + webID.substring(2).toLowerCase();
                        if (students.containsKey(webID)){
                            System.out.println("\nWelcome " + webID + ".");
                        System.out.print("\nOptions:\n" +
                                "    A) Add a class\n" +
                                "    D) Drop a class\n" +
                                "    C) View your classes sorted by course name/department\n" +
                                "    S) View your courses sorted by semester\n" +
                                "    L) Logout");

                        String op2 = "";
                        while (!op2.equals("L")) {
                            System.out.print("\nPlease select an option:");
                            op2 = scan.nextLine().toUpperCase();
                            switch (op2) {
                                case "A":
                                    System.out.print("Please enter course name:");
                                    String course = scan.nextLine().toUpperCase();
                                    if(course.length() != 7){
                                        System.out.print("That is not a valid course! Try again.\n");
                                        continue;
                                    }
                                    System.out.print("Please select a semester:");
                                    String sem = scan.nextLine().toUpperCase();
                                    if (sem.charAt(0) == 'S') {
                                        Course co = new Course(course.substring(0,3),Integer.parseInt(course.substring(4)),sem);
                                        students.get(webID).addCourse(co);
                                        System.out.print(course + " added in Spring " + sem.substring(1) + ".\n");
                                    } else if (sem.charAt(0) == 'F') {
                                        Course co = new Course(course.substring(0,3),Integer.parseInt(course.substring(4)),sem);
                                        students.get(webID).addCourse(co);
                                        System.out.print(course + " added in Fall " + sem.substring(1) + ".\n");
                                    } else {
                                        System.out.print("That is not a valid semester! Try again.\n");
                                    }
                                    break;
                                case "D":
                                    System.out.print("Please enter course name:");
                                    course = scan.nextLine().toUpperCase();
                                    if(course.length() != 7){
                                        System.out.print("That is not a valid course! Try again.\n");
                                        continue;
                                    }

                                    int check = 0;
                                    for(int i = 0; i < students.get(webID).getCourses().size(); i++){
                                        if(students.get(webID).getCourses().get(i).getDepartment().equals(course.substring(0,3)) && students.get(webID).getCourses().get(i).getNumber() == Integer.parseInt(course.substring(4))){
                                            if(students.get(webID).getCourses().get(i).getSemester().charAt(0) == 'S') {
                                                System.out.print(course + " dropped from Spring " + students.get(webID).getCourses().get(i).getSemester().substring(1) + ".\n");
                                            }else{
                                                System.out.print(course + " dropped from Fall " + students.get(webID).getCourses().get(i).getSemester().substring(1) + ".\n");
                                            }
                                            students.get(webID).getCourses().remove(i);
                                            check++;
                                        }
                                    }
                                    if(check == 0){
                                        System.out.print(webID + " is not taking " + course + "!\n");

                                    }
                                    break;
                                case "C":
                                    CourseNameComparator comp = new CourseNameComparator();
                                    int size = students.get(webID).getCourses().size();
                                    Course temp;

                                    for(int i = 0; i < size; i++){
                                        for(int j = 0; j < size-1; j++){
                                            if(comp.compare(students.get(webID).getCourses().get(j),students.get(webID).getCourses().get(j+1)) > 0){
                                                temp = students.get(webID).getCourses().get(j+1);
                                                students.get(webID).getCourses().set(j+1,students.get(webID).getCourses().get(j));
                                                students.get(webID).getCourses().set(j,temp);
                                            }
                                        }
                                    }
                                    System.out.println("\nDept. Course Semester");
                                    System.out.println("------------------------------");
                                    for(int i = 0; i < size; i++){
                                        System.out.print(students.get(webID).getCourses().get(i).toString() + "\n");
                                    }
                                    break;
                                case "S":
                                    SemesterComparator semp = new SemesterComparator();
                                    size = students.get(webID).getCourses().size();

                                    for(int i = 0; i < size; i++){
                                        for(int j = 0; j < size-1; j++){
                                            if(semp.compare(students.get(webID).getCourses().get(j),students.get(webID).getCourses().get(j+1)) > 0){
                                                temp = students.get(webID).getCourses().get(j+1);
                                                students.get(webID).getCourses().set(j+1,students.get(webID).getCourses().get(j));
                                                students.get(webID).getCourses().set(j,temp);
                                            }
                                        }
                                    }
                                    System.out.println("\nDept. Course Semester");
                                    System.out.println("------------------------------");
                                    for(int i = 0; i < size; i++){
                                        System.out.print(students.get(webID).getCourses().get(i).toString() + "\n");
                                    }
                                    break;
                                case "L":
                                    System.out.println(webID + " logged out.");
                                    break;
                                default:
                                    System.out.println("\nThat is not a choice! Try again.\n");
                                    break;
                            }
                        }
                    } else{
                            System.out.print("\n" + webID + " is not registered!\n");
                        }
                    }
                    break;
                case "X":
                    try{
                        writeToFile(students);
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Q":

                    break;
                default:
                    System.out.println("\nThat is not a choice! Try again.\n");
                    break;
            }
        }

        if(op1.equals("X")){
            System.out.print("\nSystem state saved, system shut down for maintenance.\n");
        }
        if(op1.equals("Q")) {
            System.out.print("\nGood bye, please pick the right SUNY next time!\n");
        }


        scan.close();
    }

    /** A method to write a HashMap to file using FileOutputStream
     *
     * @param students = the HashMap that will be saved to the file
     * @throws IOException if an I/O exception occurs
     */
    public static void writeToFile(HashMap<String,Student> students) throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("students.obj"));
    objectOutputStream.writeObject(students);
}

    /** A method to read a file given it's name. This method reads a file and returns a HashMap from it.
     *
     * @return students as a HashMap
     * @throws IOException if an I/O exception occurs
     * @throws ClassNotFoundException if the file is not found
     */
    public static HashMap<String,Student> readFile() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("students.obj"));
        HashMap<String,Student> students = (HashMap<String,Student>) objectInputStream.readObject();
        System.out.println("\nPrevious data loaded.\n");
        return students;
    }

}
