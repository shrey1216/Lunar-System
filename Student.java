//@author Shreyan Wankavala

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    private String webID;
    private ArrayList<Course> courses;

    /** A Student constructor which initializes the ArrayList which will be filled with classes.
     *
     */
    public Student(){
        courses = new ArrayList<>();
    }

    /** A method to set the webID of a student
     *
     * @param webID = a string which will be the new webID of the student
     */
    public void setWebID(String webID){
        this.webID = webID;
    }

    /** A method to set the courses of a student
     *
     * @param courses = an ArrayList of the courses which we can set for the student
     */
    public void setCourses(ArrayList<Course> courses){
        this.courses = courses;
    }

    /** A method to get the webID of a student
     *
     * @return the webID of the student
     */
    public String getWebID(){
        return this.webID;
    }

    /** A method to return the courses of a student as an ArrayList
     *
     * @return
     */
    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    /** A method to add courses for a specified student
     *
     * @param co = the course that is going to be added into the ArrayList
     */
    public void addCourse(Course co){
        courses.add(co);
    }
}
